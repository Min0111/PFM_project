package com.pfm.project.vo.home.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "홈페이지 카드 되돌려받는값")
public class HomeCardResponse {

    @Schema(description = "가게이름", example = "백반집")
    private String storename;

    @Schema(description = "가게주소", example = "서울 xxx")
    private String address;

    @Schema(description = "찾아오시는법", example = "홍대입구역 앞에서 500m")
    private String find;

    @Schema(description = "업종", example = "한식")
    private String storecategory;

    @Schema(description = "가게번호", example = "02-xxx-xxxx")
    private String phonenumber;

    @Schema(description = "자랑거리", example = "가격이 싸다")
    private String boast;

    public HomeCardResponse(String storename, String address, String find, String storecategory, String phonenumber, String boast) {
        this.storename = storename;
        this.address = address;
        this.find = find;
        this.storecategory = storecategory;
        this.phonenumber = phonenumber;
        this.boast = boast;
    }


    public String getStorename() {
        return storename;
    }

    public String getAddress() {
        return address;
    }

    public String getFind() {
        return find;
    }

    public String getStorecategory() {
        return storecategory;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getBoast() {
        return boast;
    }
}
