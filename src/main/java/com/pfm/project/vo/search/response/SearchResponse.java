package com.pfm.project.vo.search.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "위치 ")
public class SearchResponse {

    @Schema(description = "가게아이디",example = "3333")
    private Long storeid;

    @Schema(description = "가게이름",example = "백반집")
    private String storename;

    @Schema(description = "가게주소", example = "서울 xxxx")
    private String address;

    @Schema(description = "위도", example = "37.5679749657665")
    private String latitude;

    @Schema(description = "경도", example = "126.96761568047567")
    private String hardness;


    public SearchResponse() {
    }

    public SearchResponse(Long storeid, String storename, String address, String latitude, String hardness) {
        this.storeid = storeid;
        this.storename = storename;
        this.address = address;
        this.latitude = latitude;
        this.hardness = hardness;
    }


    public Long getStoreid() {
        return storeid;
    }

    public String getStorename() {
        return storename;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getHardness() {
        return hardness;
    }



}
