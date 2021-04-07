package edu.eci.arsw.weathermap.cache;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

import org.springframework.stereotype.Component;

@Component
public class cache implements WeatherMapCache {
	    private final ConcurrentHashMap<String, SoftReference<Object>> cache = new ConcurrentHashMap<>();
	    private final DelayQueue<objecto> cleaningUpQueue = new DelayQueue<>();

	    public cache() {
	        Thread cleanerThread = new Thread(() -> {
	            while (!Thread.currentThread().isInterrupted()) {
	                try {
	                	objecto delayedCacheObject = cleaningUpQueue.take();
	                    cache.remove(delayedCacheObject.getKey(), delayedCacheObject.getReference());
	                } catch (InterruptedException e) {
	                    Thread.currentThread().interrupt();
	                }
	            }
	        });
	        cleanerThread.setDaemon(true);
	        cleanerThread.start();
	    }


	    public void add(String key, Object value, long periodInMillis) {
	        if (key == null) {
	            return;
	        }
	        if (value == null) {
	            cache.remove(key);
	        } else {
	            long expiryTime = System.currentTimeMillis() + periodInMillis;
	            SoftReference<Object> reference = new SoftReference<>(value);
	            cache.put(key, reference);
	            cleaningUpQueue.put(new objecto(key, reference, expiryTime));
	        }
	    }

	    @Override
	    public void remove(String key) {
	        cache.remove(key);
	    }


	    @Override
	    public Object get(String key) {
	        return Optional.ofNullable(cache.get(key)).map(SoftReference::get).orElse(null);
	    }

	    @Override
	    public void clear() {
	        cache.clear();
	    }

	
	    @Override
	    public long size() {
	        return cache.size();
	    }

	}