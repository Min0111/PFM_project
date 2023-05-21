package com.pfm.project.service;

import com.pfm.project.data.PlaceRepository;
import com.pfm.project.data.ProductRepository;
import com.pfm.project.data.StoreRepository;
import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.request.SearchStoreByWordReqeust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchService {

    private final PlaceRepository placeRepasitory;

    private final StoreRepository storeRepasitory;

    private final ProductRepository productRepository;

    @Autowired
    public SearchService(PlaceRepository placeRepasitory, StoreRepository storeRepasitory, ProductRepository productRepository) {

        this.placeRepasitory = placeRepasitory;
        this.storeRepasitory = storeRepasitory;
        this.productRepository = productRepository;
    }

    // 검색에서 가게명검색 출력
    @Transactional
    public List<Store> SearchStoreName(SearchStoreByWordReqeust search) {

        return storeRepasitory.findAllByStoreNameContaining(search.getStoreName())
                .orElseThrow(IllegalArgumentException::new);

    }

    // 검색에서 가게메뉴검색 출력
    @Transactional
    public List<Store> SearchProductName(SearchStoreByWordReqeust search) {

        return storeRepasitory.findAllByProduct_ProductName(search.getStoreName())
                .orElseThrow(IllegalArgumentException::new);

    }

}
