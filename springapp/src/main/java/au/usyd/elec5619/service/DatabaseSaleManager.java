package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.dao.CartItemDao;
import au.usyd.elec5619.dao.OrderItemDao;
import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.domain.OrderTable;

@Service(value="saleManager")
@Transactional
public class DatabaseSaleManager implements SaleManager{

	@Autowired
	private OrderItemDao o;
	private CartItemDao c;

	@Override
	public void changeState(String state, int id) {
		OrderTable orders = o.getItemById(id);
		if(state.equals("Not confirmed")) {
			orders.setStatus("Not completed");
		}
		else if(state.equals("Not completed")) {
		}
		else if(state.equals("Delivered")) {
		}
		
	}

	@Override
	public List<OrderTable> getSales() {
		return o.findOrdersbySellerId();
		//return o.getOrders();
	}

	@Override
	public void addSale(OrderTable order) {
		o.saveItem(order);
	}

	@Override
	public OrderTable getSaleById(int id) {
		return o.getItemById(id);
	}

	@Override
	public void updateSale(OrderTable order) {
		o.updateItem(order);
	}

	@Override
	public void deleteSale(int id) {
		o.deleteItem(id);
	}

	
}
