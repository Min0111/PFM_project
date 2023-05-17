package com.pfm.project.dto.home.response;

import com.pfm.project.domain.place.Place;
import com.pfm.project.domain.store.Store;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "홈페이지에서 더보기 클릭시 되돌려받는 값들")
public class CardResponse {

    @Schema(description = "가게 아이디" ,example = "3333")
    private long storeid;

    @Schema(description = "가게이름", example = "백반집")
    private String storename;

    @Schema(description = "가게주소", example = "서울 xxx")
    private String address;

    @Schema(description = "업종", example = "한식")
    private String storecategory;

    @Schema(description = "가게번호", example = "02-xxx-xxxx")
    private String phonenumber;

    @Schema(description = "자랑거리", example = "가격이 싸다")
    private String pride;

    @Schema(description = "위도", example = "37.5679749657665")
    private double latitude;

    @Schema(description = "경도", example = "126.96761568047567")
    private double longtitude;

    public CardResponse(Store store) {
        this.storeid = store.getStoreId();
        this.storename = store.getStoreName();
        this.address = store.getStoreAddress();
        this.storecategory = store.getStoreTypeName();
        this.phonenumber = store.getStoreNumber();
        this.pride = store.getStorePride();

    }

    public CardResponse(Store store, Place place) {
        this.storeid = store.getStoreId();
        this.storename = store.getStoreName();
        this.address = store.getStoreAddress();
        this.storecategory = store.getStoreTypeName();
        this.phonenumber = store.getStoreNumber();
        this.pride = store.getStorePride();
        this.latitude = place.getLatitude();
        this.longtitude = place.getLongtitude();

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

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPride() {
        return pride;
    }



}
