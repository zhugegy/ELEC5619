package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.OrderTable;

public interface SaleManager extends Serializable{

    public List<OrderTable> getSales();
    
    public void addSale(OrderTable order);
    
    public OrderTable getSaleById(int id);
    
    public void updateSale(OrderTable order);
    
    public void deleteSale(int id);
    
    public void changeState(String state, int id);
        
}
