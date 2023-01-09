package com.masai.app.Service;

import java.util.List;

import com.masai.app.Entity.Fir;
import com.masai.app.Entity.User;

public interface UserService 
{
	public boolean createUser(User user);
	public boolean Login(User user);
	public User createFir(Fir fir, int id);
	public List<Fir> getAllFirs(int id);
	
}
