package com.masai.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Entity.Fir;
import com.masai.app.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaifir/user")
public class FirController 
{
	@Autowired
	UserService service;
	
	@PostMapping("/fir")
	public String addFirs(@Valid @RequestBody Fir fir, int id)
	{
		service.createFir(fir, id);
		return "Added Firs to respective user";
		}
	}

