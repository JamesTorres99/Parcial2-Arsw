package edu.eci.arsw.weathermap.cache;

import java.lang.ref.SoftReference;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class objecto implements Delayed {
	    private final String key;
	    private final SoftReference<Object> reference;
	    private final long expiryTime;


	    public objecto(String key, SoftReference<Object> reference, long expiryTime) {
	        this.key = key;
	        this.reference = reference;
	        this.expiryTime = expiryTime;
	    }

	    public String getKey() {
	        return key;
	    }

	 
	    public SoftReference<Object> getReference() {
	        return reference;
	    }

	    @Override
	    public long getDelay(TimeUnit unit) {
	        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	    }
	    
	    @Override
	    public int compareTo(Delayed o) {
	        return Long.compare(expiryTime, ((objecto) o).expiryTime);
	    }
	}
