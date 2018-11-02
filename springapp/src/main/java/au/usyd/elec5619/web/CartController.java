package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.service.CartManager;

public class CartController implements Controller {
	
	protected final Log logger = LogFactory.getLog(getClass());

    private CartManager cartManager;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String now = (new java.util.Date()).toString();
        logger.info("returning cart view with " + now);
        
        //Cart cart = new Cart();
		//cart.setName(request.getParameter("name"));
		//String name = cart.getName();
		//List<Cart> items = this.cartManager.SearchItem(name);
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("carts", this.cartManager.getCarts());
        //String message = "Uploaded! ";      
        //request.getSession().setAttribute("mes", message);
        //myModel.put("items", items);
        return new ModelAndView("cart", "model", myModel);
    }


    public void setCartManager(CartManager cartManager) {
        this.cartManager = cartManager;
    }

}
