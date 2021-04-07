package edu.eci.arsw.weathermap.connection;

import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface Connection {
	
	  JSONObject getWeather(String ciudad) throws UnirestException;	

}
