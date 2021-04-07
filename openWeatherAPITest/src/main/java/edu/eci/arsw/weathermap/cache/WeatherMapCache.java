package edu.eci.arsw.weathermap.cache;

public interface  WeatherMapCache {

	   void add(String key, Object value, long periodInMillis);
	   void remove(String key);
	   Object get(String key);
	   void clear();
	   long size();
	   
}


