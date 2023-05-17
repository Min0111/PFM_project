package com.pfm.project.dto.store.response;

import com.pfm.project.dto.product.response.ProductResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Schema(description = "업소 자세한 정보")
public class StoreDetailResponse {

    @Schema(description = "업소 정보")
    private String storeInfo;
    @Schema(description = "업소 전화 번호")
    private String storeNumber;

    @Schema(description = "찾아 오시는 길")
    private String storeWayToCome;

    @Schema(description = "업소 사진")
    private String storeUrl;

    @ArraySchema()
    private List<ProductResponse> products;

    @Builder
    public StoreDetailResponse(String storeInfo, String storeNumber, String storeWayToCome, List<ProductResponse> products, String storeUrl) {
        this.storeInfo = storeInfo;
        this.storeNumber = storeNumber;
        this.storeWayToCome = storeWayToCome;
        this.storeUrl = storeUrl;
        this.products = products;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public String getStoreWayToCome() {
        return storeWayToCome;
    }

    public String getStoreUrl() {
        return storeUrl;
    }
}
