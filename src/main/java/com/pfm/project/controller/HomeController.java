package com.pfm.project.controller;

import com.pfm.project.domain.place.Place;
import com.pfm.project.dto.home.request.HomeCoordinatesRequest;
import com.pfm.project.dto.home.response.CardResponse;
import com.pfm.project.service.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@Tag(name = "Home", description = "Home화면 관련 api")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }



    @Operation(summary = "FirstHomepage", description = "홈페이지 처음들어왔을때")
    @PostMapping("/home")
    public List<CardResponse> coordinates(@RequestBody HomeCoordinatesRequest coordinates) {

        List<Place> re = homeService.homeCoordinates(coordinates);

        List<CardResponse> response = new ArrayList<>();

        for (int i =0; i < re.size(); i++){
            CardResponse result = new CardResponse(re.get(i).getStore());
            response.add(result);
        }


        return response;
    }


    @Operation(summary = "All", description = "7개 카드 옆에 더보기 클릭시")
    @PostMapping("/map")
    public List<CardResponse> AllSelect(@RequestBody HomeCoordinatesRequest coordinates) {

       List<Place> result = homeService.AllSelect(coordinates);

        List<CardResponse> response = new ArrayList<>();

        for (int i =0; i < result.size(); i++){
            CardResponse response1 = new CardResponse(result.get(i).getStore(),result.get(i));
            response.add(response1);
        }


        return response;
    }




    @Operation(summary = "HomeSearch", description = "홈페이지 검색창")
    @GetMapping("/search/{search_name}")
    public List<CardResponse> homeSearch(@PathVariable("search_name") String search) {

        return homeService.homeSearch(search);

    }


}
