package com.pfm.project.dto.store.response;

public interface StoreBriefInfo {
    Long getStoreId();

    String getStoreName();

    int getStoreType();

    String getStorePride();

    String getStoreAddress();

    double getLatitude();

    double getLongitude();

    double getdist();

}
