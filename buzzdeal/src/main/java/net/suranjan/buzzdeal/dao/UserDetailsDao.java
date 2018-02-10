package net.suranjan.buzzdeal.dao;

import net.suranjan.buzzdeal.model.UserDetails;

public interface UserDetailsDao {
	
	public boolean RegisterUser(UserDetails User);
	public boolean UpdateUser(UserDetails User);
	public UserDetails getUser(String username);
	//public boolean ApproveUser(UserDetails user);
	

}
