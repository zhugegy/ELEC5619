package au.usyd.elec5619.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Cart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository(value = "cartItemDao")
public class CartItemDao {
	
	@Resource
    private SessionFactory sessionFactory;
	private JdbcTemplate jdbcTemplate;
	
	

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveItem(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }
    
    public Cart editQuantity(int quantity,int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Cart c = (Cart) currentSession.get(Cart.class, id);
		c.setQuantity(quantity);
		return c;
	}
    
    public Cart getItemById(int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Cart cart = (Cart) currentSession.get(Cart.class, id);
    	return cart;	
    }
    
    public void updateItem(Cart cart) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(cart);
	}
    
    public void deleteItem(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Cart cart = (Cart) currentSession.get(Cart.class, id);
		currentSession.delete(cart);
	}
	

    
	public List<Cart> getCarts() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Cart").list();
	}
	
	public List<Cart> SearchItem(String name) {
		String sql = "select cart_id, description, quantity, price, seller, name from cart where name like '%"+ name +"%'";
		return jdbcTemplate.query(sql, new CartMapper());
	}
	
	class CartMapper implements RowMapper<Cart>{

		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Cart cart = new Cart();
			cart.setId(rs.getInt(1));
			cart.setDescription(rs.getString(2));
			cart.setQuantity(rs.getInt(3));
			cart.setPrice(rs.getDouble(4));
			cart.setSeller(rs.getString(5));
			cart.setName(rs.getString(6));
			return null;
		}
		
		
	}
}
