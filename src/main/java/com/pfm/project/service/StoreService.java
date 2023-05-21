package com.pfm.project.service;


import com.pfm.project.data.PlaceRepository;
import com.pfm.project.data.ProductRepository;
import com.pfm.project.data.StoreRepository;
import com.pfm.project.domain.place.Place;
import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.response.StoreBriefInfoResponse;
import com.pfm.project.dto.store.response.StoreDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {


    private final PlaceRepository placeRepasitory;

    private final StoreRepository storeRepasitory;

    private final ProductRepository productRepository;

    @Autowired
    public StoreService(PlaceRepository placeRepasitory, StoreRepository storeRepasitory, ProductRepository productRepository) {

        this.placeRepasitory = placeRepasitory;
        this.storeRepasitory = storeRepasitory;
        this.productRepository = productRepository;
    }

    // 홈페이지 접속시 card출력
    @Transactional
    public List<Place> Coordinates() {

        List<Place> place = placeRepasitory.findAll().stream().collect(Collectors.toList());

        return place;


    }


    // 홈페이지에서 카드쪽 더보기 클릭시
    @Transactional
    public List<Store> AllSelect(String address) {

        List<Store> stores = storeRepasitory.findAllByStoreAddressContaining(address)
                .orElseThrow(IllegalArgumentException :: new).stream().collect(Collectors.toList());

        return stores;
    }







    public StoreDetailResponse findStoreDetail(Long storeId) {
//        StoreDetailResponse store = storeRepository.findById(storeId).get();
//
//        System.out.println(store);



        return StoreDetailResponse.builder().build();
    }

}
