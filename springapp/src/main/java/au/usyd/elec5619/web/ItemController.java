package au.usyd.elec5619.web;

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

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import au.usyd.elec5619.domain.Item;
import au.usyd.elec5619.service.CartManager;
import au.usyd.elec5619.service.ItemService;
import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.domain.OrderTable;
import au.usyd.elec5619.service.OrderManager;


/**
 * Handles requests for the application home page.
 */
@Controller
//make the operations are transactional
@Transactional

	@RequestMapping(value = "/shop/**")
	public class ItemController {

	@Resource(name="cartManager")
	private CartManager cartManager;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired
    private ItemService itemService;
    private int ids=0;
    
	@RequestMapping(value = "/testServiceAddItem", method = RequestMethod.GET)
	public String testServiceAddItem(Locale locale, Model model) {
		logger.info("ok");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Item tmpItem = new Item();
		
		tmpItem.setDescription("I LIKE MJ!");
		tmpItem.setQuntity(1);	
		tmpItem.setPrice(500.00);
		tmpItem.setSeller("michael jordan");
		tmpItem.setName("basketball");
		//tmpTopic.setAppendix("blankAppendix " + formattedDate);
		tmpItem.setCategory("Sports");
		
		itemService.addItem(tmpItem);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/viewItems", method = RequestMethod.GET)
	public ModelAndView viewAllTopic(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("items", this.itemService.getAllItem());

        return new ModelAndView("viewItems", "model", myModel);
	}
	
	@RequestMapping(value="/viewSpecificItem/{id}", method=RequestMethod.GET)
	public ModelAndView viewSpecificItem(@PathVariable("id") Integer id) {
		
		Item item = itemService.getItem(id);
		
		String now = (new java.util.Date()).toString();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("item", item);
        itemService.saveItem(item);
        logger.info("View specific topic. Its content is {}.");
        return new ModelAndView("viewSpecificItem", "model", myModel);
	}
	
//	@RequestMapping(value="/viewSpecificItem/{id}", method=RequestMethod.GET)
//	public String viewSpecificItem(HttpServletRequest httpServletRequest) {
//		logger.info("ok.");
//		Item item = new Item();
//		item.setItem_id(Integer.parseInt(httpServletRequest.getParameter("item_id")));
//		item.setName(httpServletRequest.getParameter("name"));
//		item.setCategory(httpServletRequest.getParameter("category"));
//		item.setQuntity(Integer.parseInt(httpServletRequest.getParameter("quntity")));
//		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
//		item.setSeller(httpServletRequest.getParameter("seller"));
//		item.setDescription(httpServletRequest.getParameter("description"));
//		//this.cartManager.addtoCart(item);
//		itemService.saveItem(item);
//		return "redirect:/shop/viewSpecificItem.htm";
//	}
	
	@RequestMapping(value="/Wantedtosell", method=RequestMethod.GET)
	public String Wantedtosell(Model uiModel) {
		
		return "Wantedtosell";
	}
	
	@RequestMapping(value="/Wantedtosell/{id}", method=RequestMethod.POST)
	public String Wantedtosell(HttpServletRequest httpServletRequest) {
		logger.info("ok.");
		Item item = new Item();
		item.setName(httpServletRequest.getParameter("name"));
		item.setCategory(httpServletRequest.getParameter("category"));
		item.setSeller(httpServletRequest.getParameter("seller"));
		item.setSeller_id(Integer.parseInt(httpServletRequest.getParameter("seller_id")));
		item.setQuntity(Integer.parseInt(httpServletRequest.getParameter("quntity")));
		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		item.setDescription(httpServletRequest.getParameter("description"));
		//this.cartManager.addtoCart(item);
		itemService.saveItem(item);
		return "redirect:/shop/viewItems.htm";
	}
	
	@RequestMapping(value="/OwnedItems", method=RequestMethod.GET)
	public String OwnedItems(Model uiModel) {
		
		return "OwnedItems";
	}
	
	@RequestMapping(value="/OwnedItems/{id}", method=RequestMethod.POST)
	public String OwnedItems(HttpServletRequest httpServletRequest) {
		logger.info("ok.");
		Item item = new Item();
		item.setName(httpServletRequest.getParameter("name"));
		item.setCategory(httpServletRequest.getParameter("category"));
		item.setSeller(httpServletRequest.getParameter("seller"));
		item.setSeller_id(Integer.parseInt(httpServletRequest.getParameter("seller_id")));
		item.setQuntity(Integer.parseInt(httpServletRequest.getParameter("quntity")));
		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		item.setDescription(httpServletRequest.getParameter("description"));
		//this.cartManager.addtoCart(item);
		itemService.updateItem(item);
		return "redirect:/shop/viewItems.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteItem(@PathVariable("id") Integer id) {
		
		itemService.deleteItem(id);
		
		return "redirect:/shop/viewItems.htm";
	}
	

	
	@RequestMapping(value="/UpdateItem", method=RequestMethod.GET)
	public String UpdateItem(Model uiModel) {
		
		return "UpdateItem";
	}
	
	@RequestMapping(value="/UpdateItem/{id}", method=RequestMethod.POST)
	public String UpdateItemSecond(HttpServletRequest httpServletRequest) {
		logger.info("ok.");
		Item item = new Item();
		item.setName(httpServletRequest.getParameter("name"));
		item.setCategory(httpServletRequest.getParameter("category"));
		item.setSeller(httpServletRequest.getParameter("seller"));
		item.setSeller_id(Integer.parseInt(httpServletRequest.getParameter("seller_id")));
		item.setQuntity(Integer.parseInt(httpServletRequest.getParameter("quntity")));
		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		item.setDescription(httpServletRequest.getParameter("description"));
		//this.cartManager.addtoCart(item);
		itemService.saveItem(item);
		return "redirect:/shop/viewItems.htm";
	}
	
//	@RequestMapping(value="/UpdateItem/{id}", method=RequestMethod.GET)
//	public ModelAndView UpdateItem(@PathVariable("id") Integer id) {
//		
//		Item item = itemService.getItem(id);
//		
//		String now = (new java.util.Date()).toString();
//		
//		Map<String, Object> myModel = new HashMap<String, Object>();
//        myModel.put("now", now);
//        myModel.put("item", item);
//        itemService.deleteItem(id);
//        logger.info("View specific topic. Its content is {}.");
//        return new ModelAndView("UpdateItem", "model", myModel);
//	}
//	
////	public ModelAndView UpdateItem(@PathVariable("id") Integer id) {
////		
////		Item item = itemService.getItem(id);
////		
////		String now = (new java.util.Date()).toString();
////		
////		Map<String, Object> myModel = new HashMap<String, Object>();
////        myModel.put("now", now);
////        myModel.put("item", item);
////        itemService.deleteItem(id);
////        //logger.info("View specific topic. Its content is {}.");
////        return new ModelAndView("UpdateItem", "model", myModel);
////	}
//	
//	@RequestMapping(value="/UpdateItem/{id}", method=RequestMethod.POST)
//	public String UpdateItemSecond(HttpServletRequest httpServletRequest) {
//		logger.info("ok.");
//		Item item = new Item();
//		item.setName(httpServletRequest.getParameter("name"));
//		item.setCategory(httpServletRequest.getParameter("category"));
//		item.setSeller(httpServletRequest.getParameter("seller"));
//		item.setSeller_id(Integer.parseInt(httpServletRequest.getParameter("seller_id")));
//		item.setQuntity(Integer.parseInt(httpServletRequest.getParameter("quntity")));
//		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
//		item.setDescription(httpServletRequest.getParameter("description"));
//		//this.cartManager.addtoCart(item);
//		itemService.saveItem(item);
//		return "redirect:/shop/viewItems.htm";
//	}
	
	@RequestMapping(value="/addtoCart/{id}")
	public String addtoCart(@PathVariable("id") int id, Model uiModel) {
		if(id != 0) {
		Cart c= new Cart();
        logger.info("View specific topic. Its content is {}.");
		//Item i= new Item();
		c.setDescription(this.itemService.getItem(id).getDescription());
		System.out.println(this.itemService.getItem(id).getDescription());
		c.setQuantity(this.itemService.getItem(id).getQuntity());
		c.setPrice(this.itemService.getItem(id).getPrice());
		c.setName(this.itemService.getItem(id).getName());
       // logger.info("View specific topic. Its content is {}.");
		c.setSellerId(this.itemService.getItem(id).getSeller_id());
		System.out.println(id);
		this.cartManager.addCart(c);
		}
		return "redirect:/cart.htm";
	}
//
//	@RequestMapping(value="/addtoCart", method=RequestMethod.POST)
//	public String addtoCart(HttpServletRequest httpServletRequest) {
//		if(ids != 0) {
//				Cart c= new Cart();
//		        logger.info("View specific topic. Its content is {}.");
//				//Item i= new Item();
//				c.setDescription(this.itemService.getItem(ids).getDescription());
//				c.setQuantity(this.itemService.getItem(ids).getQuntity());
//				c.setPrice(this.itemService.getItem(ids).getPrice());
//				c.setName(this.itemService.getItem(ids).getName());
//		       // logger.info("View specific topic. Its content is {}.");
//				c.setSellerId(this.itemService.getItem(ids).getSeller_id());
//				c.setCustomerId(Integer.parseInt(httpServletRequest.getParameter("Customer_id")));
//				System.out.println(ids);
//				cartManager.addCart(c);
//		}
//		return "redirect:viewItems.htm";
//	}

	
}