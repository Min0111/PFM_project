package com.pfm.project.dto.store.request;

import com.pfm.project.dto.place.request.PlaceRequest;
import io.swagger.v3.oas.annotations.media.Schema;

public class SearchStoreByMapReqeust {
    private final PlaceRequest leftUpPlace;
    private final PlaceRequest rightDownPlace;
    private final PlaceRequest userPlace;

    @Schema(nullable = true)
    private String storeName;

    @Schema(nullable = true)
    private int storeType;

    @Schema(nullable = true)
    private int page; //default = 0

    public SearchStoreByMapReqeust(PlaceRequest leftUpPlace, PlaceRequest rightDownPlace, PlaceRequest userPlace, String storeName, int storeType, int page) {
        this.leftUpPlace = leftUpPlace;
        this.rightDownPlace = rightDownPlace;
        this.userPlace = userPlace;
        this.storeName = storeName;
        this.storeType = storeType;
        this.page = page;
    }

    public PlaceRequest getLeftUpPlace() {
        return leftUpPlace;
    }

    public PlaceRequest getRightDownPlace() {
        return rightDownPlace;
    }

    public PlaceRequest getUserPlace() {
        return userPlace;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getStoreType() {
        return storeType;
    }

    public int getPage() {
        return page;
    }
}
