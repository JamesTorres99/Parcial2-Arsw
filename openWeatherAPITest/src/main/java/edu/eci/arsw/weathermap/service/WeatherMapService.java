package edu.eci.arsw.weathermap.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.weathermap.cache.WeatherMapCache;
import edu.eci.arsw.weathermap.connection.Connection;
import edu.eci.arsw.weathermap.connection.HttpConnection;
import edu.eci.arsw.weathermap.model.Ciudad;
import edu.eci.arsw.weathermap.model.Localidad;
import edu.eci.arsw.weathermap.model.MainData;
import edu.eci.arsw.weathermap.model.Weather;

@Service
public class WeatherMapService implements WeatherService{
	
	@Autowired
	Connection httpConnection;
	
	@Autowired
	WeatherMapCache weatherMapCache;
	 
	public WeatherMapService() {
		// TODO Auto-generated constructor stub
	}
	
    @Override
	public Ciudad getStatsByCity(String ciudad) throws UnirestException {
        if (weatherMapCache.get(ciudad) == null) {
            Ciudad cacheCiudad = agregarDetalles(ciudad);
            weatherMapCache.add(ciudad,cacheCiudad,60000);
        }
        return (Ciudad) weatherMapCache.get(ciudad);
    }
	
	private Ciudad agregarDetalles (String ciudad) throws UnirestException {
        JSONObject jsonObject = httpConnection.getWeather(ciudad);
        Gson gson = new Gson();
        Ciudad ciudadDatos = new Ciudad();
        ciudadDatos.setName(gson.fromJson(String.valueOf(jsonObject.get("name")), String.class));
        ciudadDatos.setCoord(gson.fromJson(String.valueOf(jsonObject.getJSONObject("coord")), Localidad.class));
        ciudadDatos.setWeather(gson.fromJson(String.valueOf(jsonObject.getJSONArray("weather").getJSONObject(0)), Weather.class));
        ciudadDatos.setMain(gson.fromJson(String.valueOf(jsonObject.getJSONObject("main")), MainData.class));
        return ciudadDatos;
    }
}
