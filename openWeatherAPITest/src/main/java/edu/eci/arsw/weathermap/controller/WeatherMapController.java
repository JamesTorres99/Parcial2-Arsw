package edu.eci.arsw.weathermap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.weathermap.model.Ciudad;
import edu.eci.arsw.weathermap.service.WeatherMapService;
import edu.eci.arsw.weathermap.service.WeatherService;

@RestController
@RequestMapping("weater")
public class WeatherMapController {
	
	@Autowired
	WeatherService weatherServices;

	public WeatherMapController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping()
    public ResponseEntity<?> getWeather(@RequestParam String lugar) {
        Ciudad ciudad = null;
        try {
        	ciudad = weatherServices.getStatsByCity(lugar);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
    }
}
