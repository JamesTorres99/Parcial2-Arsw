package edu.eci.arsw.weathermap.service;

import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.weathermap.model.Ciudad;

public interface WeatherService {
	
	Ciudad getStatsByCity(String ciudad) throws UnirestException;
	

}
