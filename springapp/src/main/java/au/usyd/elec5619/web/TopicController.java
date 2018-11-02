package au.usyd.elec5619.web;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Topic;
import au.usyd.elec5619.service.TopicService;

/**
 * Handles requests for the application home page.
 */
@Controller
//make the operations are transactional
@Transactional
@RequestMapping(value = "/forum/**")
public class TopicController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired
    private TopicService topicService;
    
	@RequestMapping(value = "/testServiceAddTopic", method = RequestMethod.GET)
	public String testServiceAddTopic(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Topic tmpTopic = new Topic();
		
		tmpTopic.setTitle("Rent a house");
		tmpTopic.setReplyCount(1);
		tmpTopic.setDate(formattedDate);
		tmpTopic.setContent("I am renting a house and holding a party");
		tmpTopic.setAuthor("Jim");
		//tmpTopic.setAppendix("blankAppendix " + formattedDate);
		tmpTopic.setAppendix("renting, party###dlm###Jerry##dlm##time2018##dlm##hi, ok");
		
		topicService.userPostTopic(tmpTopic);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/viewAllTopics", method = RequestMethod.GET)
	public ModelAndView viewAllTopic(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("topics", this.topicService.userGetAllTopics());

        return new ModelAndView("viewAllTopics", "model", myModel);
	}
	
	@RequestMapping(value="/deleteSpecificTopic/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Integer id) {
		
		topicService.userDeleteTopicByID(id);
		
		return "redirect:/forum/viewAllTopics.htm";
	}
	
	@RequestMapping(value="/helps", method=RequestMethod.GET)
	public String helps(Model uiModel) {
		return "helps";
	}

	
	@RequestMapping(value="/postANewTopic", method=RequestMethod.GET)
	public String postANewTopic(Model uiModel) {
		
		return "postANewTopic";
	}	
	
	@RequestMapping(value="/postANewTopic", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		
		Topic topic = new Topic();
		topic.setTitle(httpServletRequest.getParameter("title"));
		topic.setAuthor(httpServletRequest.getParameter("author"));
		
		String tagList = "";
		String select[] = httpServletRequest.getParameterValues("tag"); 
		if (select != null && select.length != 0) {
			if (select[0].equalsIgnoreCase("customized"))
			{
				tagList = httpServletRequest.getParameter("customizedTags");
			}
			else
			{
				tagList = select[0];
			}
			
			for (int i = 1; i < select.length; i++) {
				if (select[i].equalsIgnoreCase("customized"))
				{
					tagList += ", ";
					tagList += httpServletRequest.getParameter("customizedTags");
					logger.info("fukcer");
				}
				else
				{
					tagList += ", ";
					tagList += select[i];
				}
				
			}
		}
		
		tagList += "#";
		topic.setAppendix(tagList);
		
		topic.setContent(httpServletRequest.getParameter("content"));
		
		String formattedDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
		
		topic.setDate(formattedDate);
		
		topic.setReplyCount(0);
		
		topicService.userPostTopic(topic);
		
		return "redirect:/forum/viewAllTopics.htm";
	}
	
	@RequestMapping(value="/viewSpecificTopic/{id}", method=RequestMethod.GET)
	public ModelAndView viewSpecificTopic(@PathVariable("id") Integer id) {
		
		Topic topic = topicService.userGetTopicByID(id);
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("topic", topic);
        
        logger.info("View specific topic. Its content is {}.", topic.getContent());

        return new ModelAndView("viewTopic", "model", myModel);
	}
	
	@RequestMapping(value="/viewSpecificAuthor/{strName}", method=RequestMethod.GET)
	public ModelAndView viewSpecificTopic(@PathVariable("strName") String name) {
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        
        
        logger.info("fasView specific topic. Its content is {}.", name);
        
        String url = "https://api.github.com/users/" + name;       
        RestTemplate rtRestTemplate = new RestTemplate();
        
        String response = null;

        try {
        	response = rtRestTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException ex)   {
            if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
                throw ex;
            }
        }
        
        if (response == null)
        {
        	return new ModelAndView("viewAuthorNotExist", "model", myModel);
        }
        
        String [] tmp = response.split(",");
        
        
        myModel.put("name", tmp[0].substring(tmp[0].lastIndexOf(':') + 1));
        myModel.put("pic", tmp[3].substring(tmp[3].lastIndexOf(':') + 1));
        myModel.put("company", tmp[19].substring(tmp[19].lastIndexOf(':') + 1));
        myModel.put("email", tmp[22].substring(tmp[22].lastIndexOf(':') + 1));
        myModel.put("repos", tmp[25].substring(tmp[25].lastIndexOf(':') + 1));
        myModel.put("followers", tmp[27].substring(tmp[27].lastIndexOf(':') + 1));
        myModel.put("following", tmp[28].substring(tmp[28].lastIndexOf(':') + 1));

        return new ModelAndView("viewAuthor", "model", myModel);
	}
	
	@RequestMapping(value="/replySpecificTopic/{id}", method=RequestMethod.GET)
	public ModelAndView replySpecificTopic(@PathVariable("id") Integer id) {
		
		logger.info("I was here.");
		
		Topic topic = topicService.userGetTopicByID(id);
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("topicid", topic.getId());
		
        return new ModelAndView("postANewReply", "model", myModel);	
	}
	
	@RequestMapping(value="/replySpecificTopic/{id}", method=RequestMethod.POST)
	public String replySpecificTopic(HttpServletRequest httpServletRequest) {
		
		logger.info("supruisze musfcker");
		
		int idNum = Integer.parseInt(httpServletRequest.getParameter("custId"));
		
		//int idNum = 6;
		
		int id = idNum;
		Topic topic = topicService.userGetTopicByID(id);
		
		String author = httpServletRequest.getParameter("author");
		String formattedDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
		String content = httpServletRequest.getParameter("content");
		
		String artifical = author + "$" + formattedDate + "$" + content + "$";
		artifical += "#";
		
		String origin = topic.getAppendix();
		topic.setAppendix(origin + artifical);
		
		int nCurrentRly = topic.getReplyCount();
		topic.setReplyCount(nCurrentRly + 1);
		
		topicService.userPostTopic(topic);
		
		String addr = "redirect:/forum/viewSpecificTopic/";
		//addr += httpServletRequest.getParameter("id");
		addr += Integer.toString(id);
		addr += ".htm";
		
		return addr;
	}
	
	@RequestMapping(value="/deleteSpecificReply/{id}/{serial}", method=RequestMethod.GET)
	public String replySpecificTopic(@PathVariable("id") Integer id, 
			@PathVariable("serial") Integer serial) {
		
		logger.info("I was here to delete reply.");
		
		Topic topic = topicService.userGetTopicByID(id);
		
		topic.removeReply(serial);
		
		topicService.userPostTopic(topic);
		
		String addr = "redirect:/forum/viewSpecificTopic/";
		//addr += httpServletRequest.getParameter("id");
		addr += Integer.toString(id);
		addr += ".htm";
		
		return addr;	
	}
	
	@RequestMapping(value="/editSpecificReply/{id}/{serial}", method=RequestMethod.GET)
	public ModelAndView editSpecificReply(@PathVariable("id") Integer id, 
			@PathVariable("serial") Integer serial) {
		
		logger.info("I was here. serial {}", serial);
		
		Topic topic = topicService.userGetTopicByID(id);
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("topicid", topic.getId());
        myModel.put("topicreplyserial", serial);
		
        return new ModelAndView("editAReply", "model", myModel);	
	}
	
	@RequestMapping(value="/editSpecificReply/{id}/{serial}", method=RequestMethod.POST)
	public String editSpecificReplyPost(HttpServletRequest httpServletRequest) {
		
		logger.info("supruisze musfcker!!");
		
		int idNum = Integer.parseInt(httpServletRequest.getParameter("custId"));
		int idNum2 = Integer.parseInt(httpServletRequest.getParameter("custId2"));
		//int idNum = 6;
		
		int id = idNum;
		Topic topic = topicService.userGetTopicByID(id);
		
		String formattedDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
		String content = httpServletRequest.getParameter("content");
		
		logger.info("supruisze musfcker!!!{}, 2nd {}", formattedDate, content);
		
		topic.editReply(idNum2, formattedDate, content);
		
		topicService.userPostTopic(topic);
		
		String addr = "redirect:/forum/viewSpecificTopic/";
		//addr += httpServletRequest.getParameter("id");
		addr += Integer.toString(id);
		addr += ".htm";
		
		return addr;
	}
	
	@RequestMapping(value="/searchTopics", method=RequestMethod.GET)
	public String searchTopics(Model uiModel) {
		
		return "searchTopics";
	}	
	
	@RequestMapping(value="/searchTopics", method=RequestMethod.POST)
	public ModelAndView searchTopicsPost(HttpServletRequest httpServletRequest) {
		
		logger.info("fenxi");
		
		String tagList = httpServletRequest.getParameter("attributes");
		
		String tagList2 = httpServletRequest.getParameter("tosearch");
	
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        
        logger.info("1st {} 2nd {}", tagList, tagList2);
        
        List <Topic> tmpList = null;
		
		if (tagList.equalsIgnoreCase("title")) 
		{
			tmpList = topicService.userQueryTopicsByTitle(tagList2);
		}
		else if (tagList.equalsIgnoreCase("tag")) 
		{
			tmpList = topicService.userQueryTopicsByTag(tagList2);
		}
		else if (tagList.equalsIgnoreCase("author")) 
		{
			tmpList = topicService.userQueryTopicsByAuthor(tagList2);
		}
		else if (tagList.equalsIgnoreCase("content")) 
		{
			tmpList = topicService.userQueryTopicsByContent(tagList2);	
		}
		
		myModel.put("topics", tmpList);
		
		return new ModelAndView("searchTopicsResults", "model", myModel);
	}
	
	@RequestMapping(value="/searchSpecificTag/{id}", method=RequestMethod.GET)
	public ModelAndView searchSpecificTag(@PathVariable("id") String id) {
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
      
        List <Topic> tmpList = null;
		
        tmpList = topicService.userQueryTopicsByTag(id);
		myModel.put("topics", tmpList);
		
		return new ModelAndView("searchTopicsResults", "model", myModel);

	}
}
