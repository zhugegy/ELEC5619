package au.usyd.elec5619.service;

import java.util.List;

import au.usyd.elec5619.domain.User;

public class SimpleUserManager implements UserManager{
	
private List<User> users;

	public List<User> getUsers(){
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public void addUser(User user) {
		//TODO Auto-genreated method stub
		
	}

	@Override
	public User getUserById(long id) {
		//TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		//TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(long user) {
		//TODO Auto-generated method stub
		
	}

}