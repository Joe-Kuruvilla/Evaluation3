package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Entity.Fir;
import com.masai.app.Entity.User;
import com.masai.app.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaifir/user")
public class UserController 
{
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public String registeruser(@Valid @RequestBody User user)
	{
		service.createUser(user);
		return "Created";
	}
	
	@PostMapping("/login")
	public String login(@Valid @RequestBody User user)
	{
		service.Login(user);
		return "logged in successfully";
	}
	
	@GetMapping("/{id}/fir")
	public ResponseEntity<?> getAllFirs(int id)
	{
		List<Fir> firList=service.getAllFirs(id);
		return new ResponseEntity<List<Fir>>(firList, HttpStatus.CREATED);
	}
}
