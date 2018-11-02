package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.OrderTable;

public interface OrderManager extends Serializable{

    public List<OrderTable> getOrders();
    
    public void addOrder(OrderTable order);
    
    public OrderTable getOrderById(int id);
    
    public void updateOrder(OrderTable order);
    
    public void deleteOrder(int id);
    
    public void changeState(String state, int id);
        
}
