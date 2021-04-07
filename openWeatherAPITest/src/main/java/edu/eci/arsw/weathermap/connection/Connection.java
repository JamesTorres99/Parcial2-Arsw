package edu.eci.arsw.weathermap.connection;

import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.weathermap.model.Ciudad;

public interface Connection {
	
	  Ciudad getWeather(String city) throws UnirestException;	

}
