package com.pfm.project.service;

import com.pfm.project.dto.home.request.HomeCoordinatesRequest;
import com.pfm.project.dto.home.response.HomeCardResponse;
import com.pfm.project.dto.home.response.HomeCoordinatesResponse;
import com.pfm.project.dto.home.SearchResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HomeService {

//    private final HomeRepasitory home;

//    public HomeService(HomeRepasitory home) {
//        this.home = home;
//    }

    @Transactional
    public List<HomeCoordinatesResponse> homeCoordinates(HomeCoordinatesRequest req){

        List<HomeCoordinatesResponse> response = null;

        return response;

    }


    @Transactional
    public HomeCardResponse homeCard(String storeid){

        HomeCardResponse res = null;

        return res;
    }


    @Transactional
    public List<SearchResponse> homeSearch(String search,HomeCoordinatesRequest req){

        List<SearchResponse> res = null;

        return res;
    }


}
