package au.usyd.elec5619.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.hibernate.Session;
import au.usyd.elec5619.domain.Item;

@Repository(value = "ItemDao")
public class ItemDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveItem(Item item) {
        sessionFactory.getCurrentSession().save(item);   
    }
    public void addItem(Item item) {
		this.sessionFactory.getCurrentSession().save(item);
	}
//    public List<Cart> getAllCart() {
//        return sessionFactory.getCurrentSession().createCriteria(Cart.class).list();
//    }
	public List<Item> getAllItem() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Item").list();
	}
    public Item getItem(int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Item item = (Item) currentSession.get(Item.class, id);
    	return item;	
    }
//    public void deleteTopicByID(Integer id) {
//    	Session session ;
//    	Cart myObject ;
//        session = sessionFactory.getCurrentSession();
//        myObject = (Cart)session.load(Cart.class,id);
//        session.delete(myObject);
//        //This makes the pending delete to be done
//        session.flush() ;
//    }
	public void deleteItem(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Item item = (Item) currentSession.get(Item.class, id);
		currentSession.delete(item);
	}
	public void updateItem(Item item) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(item);
	}
//    public Cart queryTopicByID(Integer id) {
//    	Session session ;
//    	Cart myObject ;
//        session = sessionFactory.getCurrentSession();
//        myObject = (Cart)session.load(Cart.class,id);
//        //This makes the pending delete to be done
//        //session.flush() ;
//        return myObject;
//    }
	
//	public void increasePrice(int percentage) {
//		Session currentSession = this.sessionFactory.getCurrentSession();
//		List<Product> products = currentSession.createQuery("FROM Product").list();
//		
//		if (products != null) {
//            for (Product product : products) {
//                double newPrice = product.getPrice().doubleValue() * 
//                                    (100 + percentage)/100;
//                product.setPrice(newPrice);
//                currentSession.save(product);
//            }
//        }
//	}
}