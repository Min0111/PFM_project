package com.pfm.project.dto.store.response;

import com.pfm.project.domain.product.Product;

import java.util.List;

public interface StoreDetail {
    String getStoreInfo();
    String getStoreNumber();
    String getStoreWayToCome();
    String getStoreUrl();
    List<Product> getProduct();
}
