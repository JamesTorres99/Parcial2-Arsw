package edu.eci.arsw.weathermap.model;

public class Localidad {
	private double latitud;
	private double longitud;
	
	public Localidad(Double latitud, Double longitud) {
		this.latitud=latitud;
		this.longitud=longitud;
	}
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
}
