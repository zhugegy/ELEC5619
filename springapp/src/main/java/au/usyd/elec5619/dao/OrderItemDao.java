package au.usyd.elec5619.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.OrderTable;

@Repository(value = "orderItemDao")
public class OrderItemDao {
	@Resource
    private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveItem(OrderTable order) {
        sessionFactory.getCurrentSession().save(order);
    }
    
    public OrderTable editQuantity(int quantity,int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	OrderTable c = (OrderTable) currentSession.get(OrderTable.class, id);
		c.setQuantity(quantity);
		return c;
	}
    
    public OrderTable getItemById(int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	OrderTable order = (OrderTable) currentSession.get(OrderTable.class, id);
    	return order;	
    }
    
    public void updateItem(OrderTable order) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(order);
	}
    
    public void deleteItem(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		OrderTable order = (OrderTable) currentSession.get(OrderTable.class, id);
		currentSession.delete(order);
	}
	
	public List<OrderTable> getOrders() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM OrderTable").list();
	}
	
	public int userid() {
		String sql = "SELECT customer_id from cart";
		return 233;
	}
	
	public List<OrderTable> findOrdersbySellerId() {
		int id=this.userid();
		String sql = "SELECT * from ordertable where seller_id =" + id;
		
		return this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(OrderTable.class).list();
	}
	

}
