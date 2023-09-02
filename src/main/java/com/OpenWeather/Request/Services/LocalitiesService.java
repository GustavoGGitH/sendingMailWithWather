package com.OpenWeather.Request.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenWeather.Request.Entities.Localities;
import com.OpenWeather.Request.Repository.LocalitiesRepository;


@Service
public class LocalitiesService {

	@Autowired
	private LocalitiesRepository localitiesRepository;
	
	public Optional<Localities> findById(Integer id) {
		// TODO Auto-generated method stub
		return localitiesRepository.findById(id);
}
}
