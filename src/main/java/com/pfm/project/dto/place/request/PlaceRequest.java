package com.pfm.project.dto.place.request;

public class PlaceRequest {
    private final double latitude;
    private final double longitude;

    public PlaceRequest(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
