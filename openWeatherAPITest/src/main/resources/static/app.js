let app = (() => {

    let markers = [];

    function mapData(data){
        console.log(data);
        $("#city").empty();
        $("#city").append("<b>"+data.name+"</b>");
        $("#weather").text("Weather: "+data.weather.main);
        $("#description").text("Weather Description: "+data.weather.description);
        $("#temperature").text("Temperature: "+data.main.temp +" ºK");
        $("#max").text("Max Temperature: "+data.main.temp_max+ "ºK");
        $("#min").text("Min Temperature: "+data.main.temp_min+ "ºK");
        $("#humidity").text("Humidity: "+data.main.humidity+" %");
        plotMarkers(data.coord);

    }

    var initMap = () => {
        map = new google.maps.Map(document.getElementById("map"), {
            zoom: 2,
            center: {lat: 35.717, lng: 139.731},
        });
    }

    function clearMap(){
        if (markers){
            markers.forEach(function (marker) {
                marker.setMap(null);
            })
        }
    }

    function plotMarkers(data) {
        clearMap();
        bounds = new google.maps.LatLngBounds();
        var position = new google.maps.LatLng(data.lat, data.lon);
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );
        bounds.extend(position);
        map.fitBounds(bounds);
        map.setZoom(4);
    }

    function init() {
        initMap();
    }

    function getWeather(name){
        apiclient.getWeatherByCity(name, mapData);

    }

    return {
        init:init,
        getWeather:getWeather
    }
})();