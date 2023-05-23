package com.pfm.project.dto.place.request;




public class PlaceRequest {
    private double latitude;
    private double longitude;

    public PlaceRequest() {
    }

    public PlaceRequest(double latitude, double longtitude) {
        this.latitude = latitude;
        this.longitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
