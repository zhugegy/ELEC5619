package au.usyd.elec5619.web;

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
import au.usyd.elec5619.service.SaleManager;

@Controller
@RequestMapping(value="/sale/**")
public class SalesItemController {

	@Resource(name="saleManager")
	private SaleManager saleManager;
	@Resource(name="orderManager")
	private OrderManager orderManager;
	
	@RequestMapping(value="/change/{id}", method=RequestMethod.GET)
	public String ChangeState(@PathVariable("id") int id,Model uiModel) {
		
		OrderTable sale = this.saleManager.getSaleById(id);
		System.out.println(sale.getLocation());
		String state = sale.getStatus();
		if(state.equals("Delivered")) {
			uiModel.addAttribute("sale", sale);
			OrderTable o=new OrderTable();
			o=this.saleManager.getSaleById(id);
			return "review_seller";
		}
		else if(state.equals("Not confirmed")) {
			//this.saleManager.changeState(state, id);
			uiModel.addAttribute("sale", sale);
			OrderTable o=new OrderTable();
			o=this.saleManager.getSaleById(id);
			//uiModel.asMap().put("info", o);
			return "order_details";
		}
		else if(state.equals("Not completed")) {
			uiModel.addAttribute("sale", sale);
			OrderTable o=new OrderTable();
			o=this.saleManager.getSaleById(id);
			return "order_details";
		}
		return "redirect:/sale.htm";
		
	}
	
	@RequestMapping(value="/change/{id}", method=RequestMethod.POST)
	public String editCart(@ModelAttribute("sale") OrderTable order) {
		
		//order = this.orderManager.editQuantity(quantity, id);
		//String state=order.getStatus();
		int id=order.getId();
		System.out.println(id);
		OrderTable o=new OrderTable();
		o = this.saleManager.getSaleById(id);
		//o=this.orderManager.getOrderById(id);
		String state=o.getStatus();		
		this.saleManager.changeState(state, id);
		return "redirect:/sale.htm";
	}
}
