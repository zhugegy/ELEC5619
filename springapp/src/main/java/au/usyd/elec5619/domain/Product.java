package au.usyd.elec5619.domain;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String description;
	private double price;
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: chentest5" + description + ";");
		buffer.append("Price: chentest5" + price);
		
		return buffer.toString();
	}
	
	

}
