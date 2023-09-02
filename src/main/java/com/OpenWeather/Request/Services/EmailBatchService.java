package com.OpenWeather.Request.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OpenWeather.Request.Entities.Localities;
import com.OpenWeather.Request.Entities.Users;
import com.OpenWeather.Request.Model.WeatherData;
import com.OpenWeather.Request.Model.Wind;
import com.OpenWeather.Request.Utils.WindDirectionConverter;

import jakarta.mail.MessagingException;

@Service
public class EmailBatchService {

    @Autowired
    private UserServices userService; // Supongamos que tienes un servicio para acceder a la tabla de usuarios

    @Autowired
    private WeatherService weatherService; // Supongamos que tienes un servicio para acceder a los datos del clima

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private  LocalitiesService localitiesService;
    
    private WindDirectionConverter winDirectionConverter;

    public void sendEmailsToAllUsers() throws MessagingException {
        List<Users> users = userService.getUsers(); // Obtiene todos los usuarios de la base de datos

        for (Users user : users) {
            int cityId = user.getId_localidad(); // Obtiene el ID de la localidad desde el usuario
            String email = user.getEmail(); // Obtiene el correo electrónico desde el usuario

            WeatherData weatherData = weatherService.getWeatherDataForCity(cityId); // Obtiene datos climáticos
            Wind windData = weatherService.getWindDataForCity(cityId); // Obtiene datos del viento
            String winConverter=winDirectionConverter.convertDegreesToCardinal(weatherData.getTemp() );
            Optional<Localities> localitie=localitiesService.findById(cityId);

            String emailText = 
          		  "Estación: " + localitie.get().getNombre() + "<br>"
          		+ "Temperatura actual: " + weatherData.getTemp() + "°C<br>"
                  + "Temperatura máxima: " + weatherData.getTemp_max()+ "°C<br>"
                  + "Temperatura mínima: " + weatherData.getTemp_min() + "°C<br>"
                  + "Humedad: " + weatherData.getHumidity() + "%<br>"
                  + "Velocidad del viento: " + windData.getSpeed() + " km/h<br>"
                  + "Dirección del viento: " + winConverter + "<br>"
                  + "Velocidad máxima: " + windData.getGust() + " km/h";

            emailService.sendEmail(email, "Datos meteorológicos", emailText); // Envía el correo
        }
    }
}