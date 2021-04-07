package edu.eci.arsw.weathermap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.weathermap.connection.HttpConnection;
import edu.eci.arsw.weathermap.model.Ciudad;

@Service
public class WeatherMapService {
	
	@Autowired
	HttpConnection httpConnection;
	
	public WeatherMapService() {
		// TODO Auto-generated constructor stub
	}

	public Ciudad getStatsByCity(String ciudad) throws UnirestException {
        if (cache.get(ciudad) == null) {
            System.out.println("cache");
            Ciudad cityCache = addDetails(ciudad);
            cache.add(ciudad,cityCache,60000);
        }
        return (Ciudad) cache.get(ciudad);
    }
}
