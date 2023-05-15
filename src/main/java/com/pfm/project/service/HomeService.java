
package com.pfm.project.service;

//import com.pfm.project.data.HomeRepasitory;

import com.pfm.project.data.PlaceRepasitory;
import com.pfm.project.data.ProductRepository;
import com.pfm.project.data.StoreRepasitory;
import com.pfm.project.domain.place.Place;
import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.home.request.HomeCoordinatesRequest;
import com.pfm.project.dto.home.response.CardResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private final PlaceRepasitory placeRepasitory;

    private final StoreRepasitory storeRepasitory;

    private final ProductRepository productRepository;

    public HomeService(PlaceRepasitory placeRepasitory, StoreRepasitory storeRepasitory, ProductRepository productRepository) {
        this.placeRepasitory = placeRepasitory;
        this.storeRepasitory = storeRepasitory;
        this.productRepository = productRepository;
    }

    // 홈페이지 접속시 card출력
    @Transactional
    public List<CardResponse> homeCoordinates(HomeCoordinatesRequest req) {

        // 경도 126.96761568047567
        // 위도  37.5679749657665

//        double latitude2 = req.getLatitude()+0.0000000000003;
//        double longtitude2 = req.getLongtitude()+0.0000000000003;

        List<Place> place = placeRepasitory.findTop7ByLatitudeOrderByLatitudeDesc(req.getLatitude())
        .orElseThrow(IllegalArgumentException::new);

        List<CardResponse> response = new ArrayList<>();

        for (int i =0; i < place.size(); i++){
            response.add(place.get(i).get_Card());
        }

        return response;

    }


    // 홈페이지에서 카드쪽 더보기 클릭시
    @Transactional
    public List<CardResponse> AllSelect(HomeCoordinatesRequest req) {


        List<Place> place = placeRepasitory.findAllByLatitudeOrderByLatitudeDesc(req.getLatitude())
                .orElseThrow(IllegalArgumentException::new);

        List<CardResponse> response = new ArrayList<>();

        for (int i =0; i < place.size(); i++){
            response.add(place.get(i).get_All());
        }

        return response;

    }


    // 홈페이지에서 검색창 사용
    @Transactional
    public List<CardResponse> homeSearch(String search) {

        List<CardResponse> responses = new ArrayList<>();

        List<Store> store = storeRepasitory.findAllByStoreNameContaining(search)
                        .orElseThrow(IllegalArgumentException::new);

        List<Store> stores = storeRepasitory.findAllByProduct_ProductName(search)
                .orElseThrow(IllegalArgumentException::new);

        if(store.size() != 0){
            for (int i=0; i<stores.size();i++){
                for (int a=0; a<store.size();a++){
                    if (stores.get(i).getStoreId().equals(store.get(a).getStoreId())){
                        System.out.println(stores.get(i).getStoreName());
                        System.out.println(stores.get(i).getStorePride());
                        store.add(stores.get(i));

                    }
                }
            }
        }else {
            for (int i=0; i<stores.size();i++){
                    System.out.println(stores.get(i).getStoreName());
                    System.out.println(stores.get(i).getStorePride());
                    store.add(stores.get(i));
            }

        }

        for (int i=0; i<store.size();i++){
            responses.add(store.get(i).search());
        }

        return responses;


    }


}

