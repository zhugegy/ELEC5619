package au.usyd.elec5619.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.domain.OrderTable;
import au.usyd.elec5619.service.CartManager;
import au.usyd.elec5619.service.OrderManager;


@Controller
@RequestMapping(value="/cart/**")
public class CartItemController {
	
	
	@Resource(name="cartManager")
	private CartManager cartManager;
	@Resource(name="orderManager")
	private OrderManager orderManager;
	private int ids=0;
	String[] select=null;
	
	@RequestMapping(value="/checkout/{id}")
	public String checkout(@PathVariable("id") int id, Model uiModel) {
		ids=id;
		return "checkout";
	}
	
/*	@RequestMapping(value="/checkout")
	public String checkout( Model uiModel,HttpServletRequest httpServletRequest) {
		//ids=id;
		select=httpServletRequest.getParameterValues("foo");
		System.out.println(select[1]);
		return "checkout";
	}*/
	
	
	@RequestMapping(value="/checkout/checkout", method=RequestMethod.POST)
	public String checkout(HttpServletRequest httpServletRequest) {	
		if(ids != 0) {
				OrderTable order = new OrderTable();
				order.setDescription(this.cartManager.getCartById(ids).getDescription());
				order.setQuantity(this.cartManager.getCartById(ids).getQuantity());
				order.setPrice(this.cartManager.getCartById(ids).getPrice());
				order.setName(this.cartManager.getCartById(ids).getName());
				order.setStatus("Not confirmed");
				order.setItemId(ids);
				order.setSellerId(this.cartManager.getCartById(ids).getSellerId());
				order.setCustomerId(this.cartManager.getCartById(ids).getCustomerId());
				order.setLocation(httpServletRequest.getParameter("location"));
				order.setTime(httpServletRequest.getParameter("time"));
				order.setContact(httpServletRequest.getParameter("contact"));
				this.orderManager.addOrder(order);
        }
		
		return "redirect:/order.htm";
	}


/*	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String checkout(HttpServletRequest httpServletRequest) {	
		System.out.println(select[1]);
		if(select !=null && select.length!=0) {
			for(int i=0;i<select.length;i++) {
				OrderTable order = new OrderTable();
				order.setDescription(this.cartManager.getCartById(Integer.parseInt(select[i])).getDescription());
				order.setQuantity(this.cartManager.getCartById(Integer.parseInt(select[i])).getQuantity());
				order.setPrice(this.cartManager.getCartById(Integer.parseInt(select[i])).getPrice());
				order.setName(this.cartManager.getCartById(Integer.parseInt(select[i])).getName());
				order.setStatus("Not confirmed");
				order.setItemId(Integer.parseInt(select[i]));
				order.setSellerId(this.cartManager.getCartById(Integer.parseInt(select[i])).getSellerId());
				order.setCustomerId(this.cartManager.getCartById(Integer.parseInt(select[i])).getCustomerId());
				order.setLocation(httpServletRequest.getParameter("location"));
				order.setTime(httpServletRequest.getParameter("time"));
				order.setContact(httpServletRequest.getParameter("contact"));
				this.orderManager.addOrder(order);
			}
        }
		
		return "redirect:/order.htm";
	}*/
	
	/*@RequestMapping(value="/checkout")
	public String checkout(@RequestParam("foo") int id[], Model uiModel) {
		ids=id;
		return "checkout";
	}
	
	
	@RequestMapping(value="/checkout/checkout", method=RequestMethod.POST)
	public String checkout(HttpServletRequest httpServletRequest) {	
		if(ids != null) {
			for(int i=0;i<ids.length;i++) {
				Orders order = new Orders();
				order.setDescription(this.cartManager.getCartById(ids[i]).getDescription());
				order.setQuantity(this.cartManager.getCartById(ids[i]).getQuantity());
				order.setPrice(this.cartManager.getCartById(ids[i]).getPrice());
				order.setName(this.cartManager.getCartById(ids[i]).getName());
				order.setStatus("Not confirmed");
				order.setLocation(httpServletRequest.getParameter("location"));
				order.setTime(httpServletRequest.getParameter("time"));
				order.setContact(httpServletRequest.getParameter("contact"));
				this.orderManager.addOrder(order);
			}
        }
		return "redirect:/order.htm";
	}*/

	@RequestMapping(value="/add")
	public String addCart(Model uiModel) {
		
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCart(HttpServletRequest httpServletRequest) {
		
		Cart cart = new Cart();
		cart.setDescription(httpServletRequest.getParameter("description"));
		cart.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		cart.setSeller(httpServletRequest.getParameter("seller"));
		cart.setName(httpServletRequest.getParameter("name"));
		cart.setCustomerId(Integer.parseInt(httpServletRequest.getParameter("customer_id")));
		cart.setSellerId(Integer.parseInt(httpServletRequest.getParameter("seller_id")));
		
		this.cartManager.addCart(cart);
		
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editCart(@PathVariable("id") int id, Model uiModel) {
		
		Cart cart = this.cartManager.getCartById(id);
		uiModel.addAttribute("cart", cart);
		
		return "editb";
	}

	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editCart(@Valid int quantity, @ModelAttribute("cart") Cart cart) {
		
		int id = cart.getId();
		cart = this.cartManager.editQuantity(quantity, id);
		this.cartManager.updateCart(cart);
		System.out.println(cart.getId());
		
		return "redirect:/cart.htm";
	}
	

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteCart(@PathVariable("id") int id) {
		
		this.cartManager.deleteCart(id);
		
		return "redirect:/cart.htm";
	}
	
	public String msg(String msg) {
		return "<script>alert('" + msg + "')</script>";
	    }
	
}
