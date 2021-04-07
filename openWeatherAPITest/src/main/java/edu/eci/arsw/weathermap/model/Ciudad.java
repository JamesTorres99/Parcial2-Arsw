package edu.eci.arsw.weathermap.model;

public class Ciudad {
    private String name;
    private Localidad coord;
    private Weather weather;
    private MainData main;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Localidad getCoord() {
		return coord;
	}

	public void setCoord(Localidad coord) {
		this.coord = coord;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public MainData getMain() {
		return main;
	}

	public void setMain(MainData main) {
		this.main = main;
	}

	public Ciudad() {
		// TODO Auto-generated constructor stub
	}

	

}
