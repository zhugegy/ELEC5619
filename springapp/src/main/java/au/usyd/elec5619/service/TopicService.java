package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.usyd.elec5619.dao.TopicDao;
import au.usyd.elec5619.domain.Topic;
import junit.framework.TestCase;

@Service(value="topicService")
//@Transactional
public class TopicService {
	
	@Autowired
	private TopicDao topicDao;
	
	public void userPostTopic(Topic topic) {
		topicDao.saveTopic(topic);
    }
	
	public List<Topic> userGetAllTopics(){
	     return topicDao.getAllTopics();
	}
	
	public void userDeleteTopicByID(Integer id) {
		topicDao.deleteTopicByID(id);
    }

	public Topic userGetTopicByID(Integer id) {
		return topicDao.queryTopicByID(id);
    }
	
	public List<Topic> userQueryTopicsByContent(String str){
	     return topicDao.queryTopicByContent(str);
	}
	
	public List<Topic> userQueryTopicsByTitle(String str){
	     return topicDao.queryTopicByTitle(str);
	}
	
	public List<Topic> userQueryTopicsByAuthor(String str){
	     return topicDao.queryTopicByAuthor(str);
	}
	
	public List<Topic> userQueryTopicsByTag(String str){
	     return topicDao.queryTopicByTag(str);
	}
	
}

