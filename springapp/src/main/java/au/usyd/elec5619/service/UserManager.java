package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.User;

public interface UserManager extends Serializable{
	
	public List<User> getUsers();
	
	public void addUser(User user);
	
	public User getUserById(long id);
	
	public void updateUser(User user);
	
	public void deleteUser(long id);
	
}
