package com.pfm.project.controller;

import com.pfm.project.service.SearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/search")
@Tag(name = "Search", description = "검색 관련 api")
public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

//    @GetMapping("/location")
//    public List<SearchResponse> currentLocation(@RequestParam("name") String serach,
//                                                @RequestBody HomeCoordinatesRequest req){
//
//
//
//    }






}
