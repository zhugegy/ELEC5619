package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.Product;

public class SimpleProductManager implements ProductManager {

	private List<Product> products;
    
    public List<Product> getProducts() {
        return products;
    }

    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
            }
        }
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}

}