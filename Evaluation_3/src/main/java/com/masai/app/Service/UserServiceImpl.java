package com.masai.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.app.Entity.Fir;
import com.masai.app.Entity.User;
import com.masai.app.Repository.UserRepository;

public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepo;
	
	@Override
	public boolean createUser(User user) {
		userRepo.save(user);
		return true;
	}

	@Override
	public boolean Login(User user) {
		return true;
	}

	@Override
	public User createFir(Fir fir, int id) {
		User user=userRepo.findById(id).get();
		user.getFir().add(fir);
		fir.setUser(user);
		return userRepo.save(user);
	}

	@Override
	public List<Fir> getAllFirs(int id) {
		return userRepo.findFir(id);
	}

}
