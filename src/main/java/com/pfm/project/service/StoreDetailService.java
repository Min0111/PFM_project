package com.pfm.project.service;

import com.pfm.project.data.StoreRepository;
import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.store.response.StoreDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreDetailService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreDetailService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreDetailResponse findStoreDetail(Long storeId) {
//        StoreDetailResponse store = storeRepository.findById(storeId).get();
//
//        System.out.println(store);



        return StoreDetailResponse.builder().build();
    }

}
