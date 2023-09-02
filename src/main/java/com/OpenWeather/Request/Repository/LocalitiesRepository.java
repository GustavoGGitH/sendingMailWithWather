package com.OpenWeather.Request.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenWeather.Request.Entities.Localities;

@Repository
public interface LocalitiesRepository extends JpaRepository <Localities, Integer> {


}
