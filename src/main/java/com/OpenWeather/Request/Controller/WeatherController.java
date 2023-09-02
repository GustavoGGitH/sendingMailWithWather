package com.OpenWeather.Request.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OpenWeather.Request.Entities.Localities;
import com.OpenWeather.Request.Model.WeatherData;
import com.OpenWeather.Request.Model.Wind;
import com.OpenWeather.Request.Services.EmailService;
import com.OpenWeather.Request.Services.LocalitiesService;
import com.OpenWeather.Request.Services.WeatherService;
import com.OpenWeather.Request.Utils.WindDirectionConverter;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private  LocalitiesService localitiesService;
    

    

    
    private WindDirectionConverter winDirectionConverter;

    @GetMapping("/send-email/{cityId}/{email}")
    public String sendEmailForCity(@PathVariable int cityId, @PathVariable String email) throws MessagingException {
        WeatherData weatherData = weatherService.getWeatherDataForCity(cityId);
        Wind windData = weatherService.getWindDataForCity(cityId);
        String winConverter=winDirectionConverter.convertDegreesToCardinal(weatherData.getTemp() );
        Optional<Localities> localitie=localitiesService.findById(cityId);
      
       

        // Construye el contenido del correo
        String emailText = 
        		  "Estación: " + localitie.get().getNombre() + "<br>"
        		+ "Temperatura actual: " + weatherData.getTemp() + "°C<br>"
                + "Temperatura máxima: " + weatherData.getTemp_max()+ "°C<br>"
                + "Temperatura mínima: " + weatherData.getTemp_min() + "°C<br>"
                + "Humedad: " + weatherData.getHumidity() + "%<br>"
                + "Velocidad del viento: " + windData.getSpeed() + " km/h<br>"
                + "Dirección del viento: " + winConverter + "<br>"
                + "Velocidad máxima: " + windData.getGust() + " km/h";
        // Envía el correo
        emailService.sendEmail(email, "Datos meteorológicos", emailText);

        return "Correo enviado con éxito a " + email;
    }
}