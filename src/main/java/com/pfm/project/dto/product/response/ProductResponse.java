package com.pfm.project.dto.product.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "업소 음식 정보")
public class ProductResponse {
    @Schema(description = "음식 이름")
    private String productName;

    @Schema(description = "음식 가격")
    private int price;

    public ProductResponse(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
