package com.pfm.project.controller;

import com.pfm.project.dto.home.request.HomeCoordinatesRequest;
import com.pfm.project.dto.home.response.CardResponse;
import com.pfm.project.service.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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

        List<CardResponse> re = homeService.homeCoordinates(coordinates);

        if (re.size() !=0){
            System.out.println(re.size());
        }else {
            System.out.println(re.size());
        }

        return homeService.homeCoordinates(coordinates);
    }


    @Operation(summary = "All", description = "7개 카드 옆에 더보기 클릭시")
    @PostMapping("/map")
    public List<CardResponse> AllSelect(@RequestBody HomeCoordinatesRequest coordinates) {

       // List<AllSelectResponse> re = homeService.AllSelect(coordinates);

//        if (re.size() !=0){
//            System.out.println(re.size());
//        }else {
//            System.out.println(re.size());
//        }

        return homeService.AllSelect(coordinates);
    }




    @Operation(summary = "HomeSearch", description = "홈페이지 검색창")
    @GetMapping("/search/{search_name}")
    public List<CardResponse> homeSearch(@PathVariable("search_name") String search) {

        return homeService.homeSearch(search);

    }


}
