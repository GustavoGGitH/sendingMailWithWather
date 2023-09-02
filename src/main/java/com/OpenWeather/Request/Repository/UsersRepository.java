package com.OpenWeather.Request.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenWeather.Request.Entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{

}
