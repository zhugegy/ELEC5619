package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderTable")
public class OrderTable implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="seller_id")
    private int seller_id;
	
	@Column(name="customer_id")
    private int customer_id;
	
	@Column(name="item_id")
    private int item_id;
	
	@Column(name="description")
    private String description;
	
	@Column(name="name")
    private String name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="orderprint")
	private String orderprint;
	
	@Column(name="saleprint")
	private String saleprint;
	
	@Column(name="review")
    private String review;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
    private Double price;
	
	@Column(name="location")
	private String location;
	
	@Column(name="time")
	private String time;
	
	@Column(name="contact")
	private String contact;
	
	public int getId() {
		return order_id;
	}
	
	public void setId(int order_id) {
		this.order_id = order_id;
	}
	
	public int getSellerId() {
		return seller_id;
	}

	public void setSellerId(int seller_id) {
		this.seller_id = seller_id;
	}
	
	public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
	public int getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public int getItemId() {
		return item_id;
	}

	public void setItemId(int item_id) {
		this.item_id = item_id;
	}
	
	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
        if(status.equals("Not confirmed")) {
			setOrderprint("Cancel");
			setSaleprint("View the order details");
		}
		else if(status.equals("Not completed")) {
			setOrderprint("Complete");
			setSaleprint("View the order details");
		}
		else if(status.equals("Delivered")) {
			setOrderprint("Please enter the review");
			setSaleprint("View the product review");
		}
    }
    
    public String getOrderprint() {
        return orderprint;
    }
    
    public void setOrderprint(String orderprint) {
        this.orderprint = orderprint;
    }
    
    public String getSaleprint() {
        return saleprint;
    }
    
    public void setSaleprint(String saleprint) {
        this.saleprint = saleprint;
    }
    
    public String getReview() {
        return review;
    }
    
    public void setReview(String review) {
        this.review = review;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
}
