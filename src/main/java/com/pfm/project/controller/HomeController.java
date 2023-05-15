package com.pfm.project.controller;

//import com.pfm.project.service.HomeService;
//import com.pfm.project.dto.home.request.HomeCoordinatesRequest;
//import com.pfm.project.dto.home.response.HomeCardResponse;
//import com.pfm.project.dto.home.response.HomeCoordinatesResponse;
//import com.pfm.project.dto.home.SearchResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/index")
@Tag(name = "Home", description = "Home화면 관련 api")
public class HomeController {

//    private final HomeService service;
//
//    public HomeController(HomeService service) {
//        this.service = service;
//    }
//
//    @Operation(summary = "FirstHomepage", description = "홈페이지 처음들어왔을때")
//    @PostMapping("/home")
//    public List<HomeCoordinatesResponse> coordinates(@RequestBody HomeCoordinatesRequest coordinates) {
//
//        return service.homeCoordinates(coordinates);
//    }
//
//
//    @Operation(summary = "HomeCard", description = "홈페이지 카드클릭시반응")
//    @GetMapping("/card")
//    public HomeCardResponse coordinates(@RequestParam("storeid") String storeid) {
//
//        return service.homeCard(storeid);
//
//    }
//
//    @GetMapping("/search")
//    public List<SearchResponse> homeSearch(@RequestParam("name") String serach,
//                                           @RequestBody HomeCoordinatesRequest req) {
//
//        return service.homeSearch(serach, req);
//
//
//    }


}
