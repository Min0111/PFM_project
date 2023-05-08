package com.pfm.project.vo.home.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "홈화면 requset좌표 받기")
public class HomeCoordinatesRequest {

    @Schema(description = "위도", example = "37.5679749657665")
    private String latitude;


    @Schema(description = "경도", example = "126.96761568047567")
    private String hardness;



    public String getLatitude() {
        return latitude;
    }

    public String getHardness() {
        return hardness;
    }
}
