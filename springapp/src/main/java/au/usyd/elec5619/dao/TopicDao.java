package au.usyd.elec5619.dao;

import javax.annotation.Resource;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Topic;

@Repository(value = "topicDao")
public class TopicDao {

	@Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveTopic(Topic topic) {
        sessionFactory.getCurrentSession().save(topic);
    }
    
    public List<Topic> getAllTopics() {
        return sessionFactory.getCurrentSession().createCriteria(Topic.class).list();
    }
    
    public void deleteTopicByID(Integer id) {
    	Session session ;
        Topic myObject ;

        session = sessionFactory.getCurrentSession();
        myObject = (Topic)session.load(Topic.class,id);
        session.delete(myObject);

        //This makes the pending delete to be done
        session.flush() ;
    }
    
    public Topic queryTopicByID(Integer id) {
    	Session session ;
        Topic myObject ;

        session = sessionFactory.getCurrentSession();
        myObject = (Topic)session.load(Topic.class,id);

        //This makes the pending delete to be done
        //session.flush() ;
        
        return myObject;
    }
    
    public List<Topic> queryTopicByContent(String str)
    {    	
    	String tmp = "%";
    	tmp += str.replace(' ', '%');
    	tmp += "%";
    	
    	Criteria creteria =sessionFactory.getCurrentSession().createCriteria(Topic.class);
        creteria.add(Expression.like("content", tmp));
        List<Topic> result = (List<Topic>)creteria.list();
    	
    	return result;
    }
    
    public List<Topic> queryTopicByTitle(String str)
    {    	
    	String tmp = "%";
    	tmp += str.replace(' ', '%');
    	tmp += "%";
    	
    	Criteria creteria =sessionFactory.getCurrentSession().createCriteria(Topic.class);
        creteria.add(Expression.like("title", tmp));
        List<Topic> result = (List<Topic>)creteria.list();
    	
    	return result;
    }
    
    public List<Topic> queryTopicByAuthor(String str)
    {    	
    	String tmp = "%";
    	tmp += str.replace(' ', '%');
    	tmp += "%";
    	
    	Criteria creteria =sessionFactory.getCurrentSession().createCriteria(Topic.class);
        creteria.add(Expression.like("author", tmp));
        List<Topic> result = (List<Topic>)creteria.list();
    	
    	return result;
    }
    
    public List<Topic> queryTopicByTag(String str)
    {    	
    	String tmp = "%";
    	tmp += str.replace(' ', '%');
    	tmp += "%";
    	
    	Criteria creteria =sessionFactory.getCurrentSession().createCriteria(Topic.class);
        creteria.add(Expression.like("appendix", tmp));
        List<Topic> result = (List<Topic>)creteria.list();
    	
    	return result;
    }
    
}
