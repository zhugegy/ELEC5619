package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.UserManager;

@Controller
@RequestMapping(value="/user/**")
public class UserController {
	
	private long UserId;
	
	@Resource(name="userManager")
	private UserManager userManager;
	
	@RequestMapping(value="/register")
	public String addUser(Model uiModel) {
		
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String addUser(HttpServletRequest httpServletRequest) {
		
		User user = new User();
//		user.setId(Long.valueOf(httpServletRequest.getParameter("id")));
		user.setUsername(httpServletRequest.getParameter("username"));
		user.setPassword(httpServletRequest.getParameter("password"));
		this.userManager.addUser(user);
		
		return "redirect:/hello.htm";
	}
	
	@RequestMapping(value="/login")
    public String showLogin(){
        return "login";
    }
	
	@RequestMapping(value="/validateUser", method=RequestMethod.POST)
	public String validateUser(@RequestParam("id")String id, @RequestParam("password")String password, Model model) {
		List<User> userlist = this.userManager.getUsers();
		for(User user:userlist) {
			if(String.valueOf(user.getId()).equals(id) && user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "redirect:/hello.htm";
			}
		}
		return "login";
	}
	
	
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object>myModel = new HashMap<String, Object>();
		myModel.put("users", this.userManager.getUsers());
		
		return new ModelAndView("manage", "model", myModel);
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping(value="/show/{id}", method=RequestMethod.GET) 
	public String showUser(@PathVariable("id") Long id, Model uiModel) {
		
		User user = this.userManager.getUserById(id);
		uiModel.addAttribute("user", user);
		
		return "show";
    } 	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editUser(@PathVariable("id") Long id, Model uiModel) {
		
		User user = this.userManager.getUserById(id);
		uiModel.addAttribute("user", user);
		
		return "edit";
	}
	
	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editUser(@Valid User user) {
		
		this.userManager.updateUser(user);
		System.out.println(user.getId());
		
		return "redirect:/user/manage.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id) {
		
		this.userManager.deleteUser(id);
		
		return "redirect:/user/manage.htm";
	}
}