package com.pfm.project.service;

import com.pfm.project.data.StoreRepository;
import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.place.response.PlaceResponse;
import com.pfm.project.dto.store.request.SearchStoreByMapReqeust;
import com.pfm.project.dto.store.response.StoreBriefInfo;
import com.pfm.project.dto.store.response.StoreBriefInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    private final StoreRepository storeRepository;

    private int getOffsetByPage(int page) {
        return (page) * 20;
    }


    @Autowired
    public SearchService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<StoreBriefInfoResponse> searchStoreByMap(SearchStoreByMapReqeust searchStoreByMapReqeust) {
        String userInput = searchStoreByMapReqeust.getStoreName();
        Integer storeType = searchStoreByMapReqeust.getStoreType();
        List<StoreBriefInfo> sqlResults = null;
        List<StoreBriefInfoResponse> result = new ArrayList<>();

        if (userInput != null) {
            sqlResults = storeRepository.findAllByMapOrderByDistanceWithWord(
                    searchStoreByMapReqeust.getLeftUpPlace().getLatitude(),
                    searchStoreByMapReqeust.getLeftUpPlace().getLongitude(),
                    searchStoreByMapReqeust.getRightDownPlace().getLatitude(),
                    searchStoreByMapReqeust.getRightDownPlace().getLongitude(),
                    searchStoreByMapReqeust.getUserPlace().getLatitude(),
                    searchStoreByMapReqeust.getUserPlace().getLongitude(),
                    searchStoreByMapReqeust.getStoreName(),
                    getOffsetByPage(searchStoreByMapReqeust.getPage())
            );

        } else if (storeType != null) {
            sqlResults = storeRepository.findAllByMapOrderByDistanceWithCategory(
                    searchStoreByMapReqeust.getLeftUpPlace().getLatitude(),
                    searchStoreByMapReqeust.getLeftUpPlace().getLongitude(),
                    searchStoreByMapReqeust.getRightDownPlace().getLatitude(),
                    searchStoreByMapReqeust.getRightDownPlace().getLongitude(),
                    searchStoreByMapReqeust.getUserPlace().getLatitude(),
                    searchStoreByMapReqeust.getUserPlace().getLongitude(),
                    searchStoreByMapReqeust.getStoreType(),
                    getOffsetByPage(searchStoreByMapReqeust.getPage())
            );


        } else {
            sqlResults = storeRepository.findAllByMapOrderByDistance(
                    searchStoreByMapReqeust.getLeftUpPlace().getLatitude(),
                    searchStoreByMapReqeust.getLeftUpPlace().getLongitude(),
                    searchStoreByMapReqeust.getRightDownPlace().getLatitude(),
                    searchStoreByMapReqeust.getRightDownPlace().getLongitude(),
                    searchStoreByMapReqeust.getUserPlace().getLatitude(),
                    searchStoreByMapReqeust.getUserPlace().getLongitude(),
                    getOffsetByPage(searchStoreByMapReqeust.getPage())
            );
        }

        for (StoreBriefInfo s : sqlResults) {
            result.add(
                    StoreBriefInfoResponse.builder()
                            .storeId(s.getStoreId())
                            .storeName(s.getStoreName())
                            .storeType(s.getStoreType())
                            .storePride(s.getStorePride())
                            .storeAddress(s.getStoreAddress())
                            .place(
                                    PlaceResponse.builder()
                                            .latitude(s.getLatitude())
                                            .longitude(s.getLongitude())
                                            .build()
                            )
                            .build()
            );
        }



        return result;

    }


//    public List<SearchResponse> currentLocation(String search, HomeCoordinatesRequest req){
//
//
//
}
