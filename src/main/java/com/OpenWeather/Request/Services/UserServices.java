package com.OpenWeather.Request.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenWeather.Request.Entities.Users;
import com.OpenWeather.Request.Repository.UsersRepository;

@Service
public class UserServices {
	
	@Autowired
	
	public UsersRepository userRepository;
	
	
	public List<Users> getUsers() {
		return userRepository.findAll();
	}

}
