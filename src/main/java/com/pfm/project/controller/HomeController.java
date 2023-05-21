package com.pfm.project.controller;

import com.pfm.project.domain.place.Place;
import com.pfm.project.domain.store.Store;
import com.pfm.project.dto.ErrorResponseBody;
import com.pfm.project.dto.SuccessResponseBody;
import com.pfm.project.dto.place.request.PlaceRequest;
import com.pfm.project.dto.store.request.SearchStoreByUserPlaceRequest;
import com.pfm.project.dto.store.request.SearchStoreByWordReqeust;
import com.pfm.project.dto.store.response.StoreBriefInfoResponse;
import com.pfm.project.dto.store.response.StoreCardMeterComparator;
import com.pfm.project.service.SearchService;
import com.pfm.project.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/")
@Tag(name = "Home", description = "Home화면 관련 api")
public class HomeController {


    private final StoreService storeService;
    private final SearchService searchService;


    public HomeController(StoreService storeService, SearchService searchService) {
        this.storeService = storeService;
        this.searchService = searchService;
    }

    @Operation(summary = "FirstHomepage", description = "홈페이지 처음들어왔을때")
    @PostMapping("/home")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "홈페이지 7카드의 되돌려받는 값",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })
    public ResponseEntity Cardcoordinates(@RequestBody PlaceRequest place) {

        try {
            List<Place> places = storeService.Coordinates();
            List<StoreBriefInfoResponse> responses = new ArrayList<>();

            for (int i = 0; i < places.size(); i++) {

                double theta = place.getLongtitude() - places.get(i).getLongtitude();
                double dist = Math.sin(Math.toRadians(place.getLatitude())) * Math.sin(Math.toRadians(places.get(i).getLatitude()))
                        + Math.cos(Math.toRadians(place.getLatitude())) * Math.cos(Math.toRadians(places.get(i).getLatitude()))
                        * Math.cos(Math.toRadians(theta));

                dist = Math.acos(dist);
                dist = Math.toDegrees(dist);
                dist = dist * 60 * 1.1515;
                dist = dist * 1609.344;

                int m = (int) Math.round(dist / 10) * 10;

                if (m <= 2000) {
                    StoreBriefInfoResponse result = new StoreBriefInfoResponse(places.get(i), m);
                    responses.add(result);
                }
            }

            responses.sort(new StoreCardMeterComparator());


            ResponseEntity response = ResponseEntity.ok().body(
                    SuccessResponseBody
                            .<List<StoreBriefInfoResponse>>builder()
                            .status(HttpStatus.OK)
                            .message("Successfully found stores by words")
                            .data(responses)
                            .build());
            return response;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseBody());
        }


    }


    @Operation(summary = "All", description = "7개 카드 옆에 더보기 클릭시")
    @PostMapping("/search/map")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "홈페이지에서 더보기 이동시 되돌려 받는 값",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })
    public ResponseEntity AllSelect(@RequestBody SearchStoreByUserPlaceRequest userPlaceRequest) {

        try {

            List<Store> stores = storeService.AllSelect(userPlaceRequest.getAddress());
            StoreBriefInfoResponse result;
            List<StoreBriefInfoResponse> result2 = new ArrayList<>();
            List<StoreBriefInfoResponse> response_filter = new ArrayList<>();
            HashMap<Integer, List<StoreBriefInfoResponse>> responses = new HashMap<>();

            for (int i = 0; i < stores.size(); i++) {

                double theta = userPlaceRequest.getUserPlace().getLongtitude() - stores.get(i).getPlace().getLongtitude();
                double dist = Math.sin(Math.toRadians(userPlaceRequest.getUserPlace().getLatitude())) * Math.sin(Math.toRadians(stores.get(i).getPlace().getLatitude()))
                        + Math.cos(Math.toRadians(userPlaceRequest.getUserPlace().getLatitude())) * Math.cos(Math.toRadians(stores.get(i).getPlace().getLatitude()))
                        * Math.cos(Math.toRadians(theta));

                dist = Math.acos(dist);
                dist = Math.toDegrees(dist);
                dist = dist * 60 * 1.1515;
                dist = dist * 1609.344;

                int m = (int) Math.round(dist / 10) * 10;

                result = new StoreBriefInfoResponse(stores.get(i), m);
                result2.add(result);


            }

            result2.sort(new StoreCardMeterComparator());


            int checknum = 1;
            for (int i = 0; i < result2.size(); i++) {
                response_filter.add(result2.get(i));
                if (response_filter.size() == 20) {
                    responses.put(checknum, new ArrayList<StoreBriefInfoResponse>(response_filter));
                    System.out.println();
                    response_filter.clear();
                    checknum++;
                }
            }

            ResponseEntity response = ResponseEntity.ok().body(
                    SuccessResponseBody
                            .<HashMap<Integer, List<StoreBriefInfoResponse>>>builder()
                            .status(HttpStatus.OK)
                            .message("Successfully found stores by words")
                            .data(responses)
                            .build());
            return response;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseBody());
        }
    }


    @Operation(summary = "HomeSearch", description = "홈페이지 검색창")
    @PostMapping("/search")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "홈페이지에서 검색창 사용시",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })
    public ResponseEntity homeSearch(@RequestBody SearchStoreByWordReqeust search) {
        try {
            List<Store> storename = searchService.SearchStoreName(search);
            List<Store> productname = searchService.SearchProductName(search);
            List<Store> DB_filter = null;

            List<StoreBriefInfoResponse> result = new ArrayList<>();
            List<StoreBriefInfoResponse> response_filter = new ArrayList<>();
            HashMap<Integer, List<StoreBriefInfoResponse>> responses = new HashMap<>();


            if (storename.size() != 0 && productname.size() != 0) {
                for (int i = 0; i < storename.size(); i++) {
                    for (int a = 0; a < productname.size(); a++) {
                        if (storename.get(i).getStoreId().equals(productname.get(a).getStoreId())) {
                            storename.remove(i);
                            break;
                        }
                    }
                }
            }
            DB_filter = Stream.of(storename, productname)
                    .flatMap(x -> x.stream())
                    .collect(Collectors.toList());

            if (DB_filter.size() == 0) {
                System.out.println("데이터 베이스에 없음");
                ResponseEntity response = ResponseEntity.ok().body(
                        SuccessResponseBody
                                .<HashMap<Integer, List<StoreBriefInfoResponse>>>builder()
                                .status(HttpStatus.OK)
                                .message("Successfully found stores by words")
                                .data(responses)
                                .build());
                return response;
            } else {
                for (int i = 0; i < DB_filter.size(); i++) {
                    if (DB_filter.get(i).getStoreAddress().indexOf(search.getAddress()) != -1) {
                        StoreBriefInfoResponse into =
                                new StoreBriefInfoResponse(DB_filter.get(i));
                        result.add(into);
                    }
                }

                int checknum = 1;
                for (int i = 0; i < result.size(); i++) {
                    response_filter.add(result.get(i));
                    if (response_filter.size() == 1) {

                        responses.put(checknum, new ArrayList<StoreBriefInfoResponse>(response_filter));
                        response_filter.clear();
                        checknum++;
                    }
                }
                ResponseEntity response = ResponseEntity.ok().body(
                        SuccessResponseBody
                                .<HashMap<Integer, List<StoreBriefInfoResponse>>>builder()
                                .status(HttpStatus.OK)
                                .message("Successfully found stores by words")
                                .data(responses)
                                .build());
                return response;


            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseBody());
        }
    }


}
