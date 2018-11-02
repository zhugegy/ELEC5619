package au.usyd.elec5619.domain;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import junit.framework.TestCase;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	private Product product;
	
	protected void setUp() throws Exception
	{
		product = new Product();
	}
	
	public void testSetAndGetDescription()
	{
		String testDEscription = "aDescriptin";
		assertNotNull(product.getDescription());
		product.setDescription(testDEscription);
		assertEquals(testDEscription, product.getDescription());
		
	}
	
	public void testSetAndGetPrice()
	{
		double testPrice = 100.00;
		assertEquals(0, 0, 0);
		
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
		
	}

}
