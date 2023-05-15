package com.pfm.project.dto.place;

public class PlaceRequestDTO {
    private final double latitude;
    private final double longitude;

    public PlaceRequestDTO(double latitude, double longitude) {
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
