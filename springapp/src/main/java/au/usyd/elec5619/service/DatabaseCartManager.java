package au.usyd.elec5619.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.dao.CartItemDao;
import au.usyd.elec5619.domain.Cart;

@Service(value="cartManager")
@Transactional
public class DatabaseCartManager implements CartManager {
	
	@Autowired
	private CartItemDao m;
	
	
	@Override
	public void addCart(Cart cart) {
		m.saveItem(cart);
		//m.saveItem(product);
	}
	
	@Override
	public Cart getCartById(int id) {
		
		return m.getItemById(id);
		
	}
	
	@Override
	public void updateCart(Cart cart) {
		
		m.updateItem(cart);
	}
	
	
	@Override
	public void deleteCart(int id) {
		//Session currentSession = this.sessionFactory.getCurrentSession();
		//Product product = (Product) currentSession.get(Product.class, id);
		//currentSession.delete(product);
		m.deleteItem(id);
	}


	@Override
	public List<Cart> getCarts() {
		//return sessionFactory.getCurrentSession().createQuery("FROM Cart").list();
		return m.getCarts();
	}

	@Override
	public Cart editQuantity(int quantity,int id) {
		return m.editQuantity(quantity, id);
	}

}
