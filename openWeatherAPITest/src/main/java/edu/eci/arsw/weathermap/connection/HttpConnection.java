package edu.eci.arsw.weathermap.connection;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class HttpConnection {
	private String url, key;
	
	public HttpConnection() {
		url = "http://api.openweathermap.org/data/2.5";
		key = "cacc365971fdc4c009bca29a9d6850cb";
	}
	
	
	public  JSONObject getWeather(String ciudad) throws UnirestException {
			HttpResponse<String> response = Unirest.get(url+ "/weather?q=" + ciudad + "&appid=" + key)
                    .asString();
			System.out.println(response);
			return new JSONObject(response.getBody());
	}	
}
