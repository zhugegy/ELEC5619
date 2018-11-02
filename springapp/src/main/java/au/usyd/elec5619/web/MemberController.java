package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.service.UserManager;

public class MemberController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());
	
	private UserManager userManager;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String now = (new java.util.Date()).toString();
		logger.info("returning managerment view with " + now);
		
		Map<String, Object>myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("users", this.userManager.getUsers());
		
		return new ModelAndView("manage", "model", myModel);
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}