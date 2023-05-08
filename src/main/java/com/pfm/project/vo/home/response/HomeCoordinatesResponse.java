package com.pfm.project.vo.home.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "홈페이지로 response")
public class HomeCoordinatesResponse {

    @Schema(description = "가게 아이디" ,example = "3333")
    private long storeid;
    @Schema(description = "가게 이름" ,example = "백반집")
    private String storename;
    @Schema(description = "가게 주소" ,example = "서울 xxx xxx")
    private String address;
    @Schema(description = "업종" ,example = "한식")
    private String storecategory;

    public HomeCoordinatesResponse() {
    }

    public HomeCoordinatesResponse(long storeid, String storename, String address, String storecategory) {
        this.storeid = storeid;
        this.storename = storename;
        this.address = address;
        this.storecategory = storecategory;
    }

    public long getStoreid() {
        return storeid;
    }

    public String getStorename() {
        return storename;
    }

    public String getAddress() {
        return address;
    }

    public String getStorecategory() {
        return storecategory;
    }
}
