package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.dao.OrderItemDao;
import au.usyd.elec5619.domain.OrderTable;

@Service(value="orderManager")
@Transactional
public class DatabaseOrderManager implements OrderManager{

	@Autowired
	private OrderItemDao o;
	
	@Override
	public List<OrderTable> getOrders() {
		
		return o.getOrders();
	}

	@Override
	public void addOrder(OrderTable order) {
		
		o.saveItem(order);
	}

	@Override
	public OrderTable getOrderById(int id) {

		return o.getItemById(id);
	}

	@Override
	public void updateOrder(OrderTable order) {
		
		o.updateItem(order);
		
	}

	@Override
	public void deleteOrder(int id) {
		
		o.deleteItem(id);
	}

	@Override
	public void changeState(String state, int id) {
		OrderTable orders = o.getItemById(id);
		if(state.equals("Not confirmed")) {
			orders.setStatus("Not completed");
		}
		else if(state.equals("Not completed")) {
			orders.setStatus("Delivered");
		}
		else if(state.equals("Delivered")) {
		}	
	}

}
