package com.pfm.project.dto;

import com.pfm.project.dto.place.PlaceRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;

public class searchStoreByMapReqeustDTO {
    private final PlaceRequestDTO leftUpPlace;
    private final PlaceRequestDTO rightDownPlace;

    private final PlaceRequestDTO userPlace;

    @Schema(nullable = true)
    private String storeName;

    @Schema(nullable = true)
    private int storeType;

    private int page;

    public searchStoreByMapReqeustDTO(PlaceRequestDTO leftUpPlace, PlaceRequestDTO rightDownPlace, PlaceRequestDTO userPlace, String storeName, int storeType, int page) {
        this.leftUpPlace = leftUpPlace;
        this.rightDownPlace = rightDownPlace;
        this.userPlace = userPlace;
        this.storeName = storeName;
        this.storeType = storeType;
        this.page = page;
    }

    public PlaceRequestDTO getLeftUpPlace() {
        return leftUpPlace;
    }

    public PlaceRequestDTO getRightDownPlace() {
        return rightDownPlace;
    }

    public PlaceRequestDTO getUserPlace() {
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
