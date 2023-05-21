package com.pfm.project.dto.place.request;




public class PlaceRequest {
    private double latitude;
    private double longtitude;

    public PlaceRequest() {
    }

    public PlaceRequest(double latitude, double longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }
}
