package com.pfm.project.controller;

import com.pfm.project.dto.ErrorResponseBody;
import com.pfm.project.dto.SuccessResponseBody;
import com.pfm.project.dto.store.request.SearchStoreByCategoryReqeust;
import com.pfm.project.dto.store.request.SearchStoreByMapReqeust;
import com.pfm.project.dto.store.response.StoreBriefInfo;
import com.pfm.project.dto.store.request.SearchStoreByUserPlaceRequest;
import com.pfm.project.dto.store.request.SearchStoreByWordReqeust;
import com.pfm.project.dto.store.response.StoreBriefInfoResponse;
import com.pfm.project.service.SearchService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Store", description = "업소 관련 api")
@RequestMapping("/search")
public class SearchController {

    final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @PostMapping("/user_place/stores")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 간단 정보 리스트",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })

    public ResponseEntity searchStoreByUserPlace(@RequestBody SearchStoreByUserPlaceRequest searchStoreByUserPlaceRequest) {
         try {
             List<StoreBriefInfoResponse> storeBriefInfosResponse = new ArrayList();

            ResponseEntity response =  ResponseEntity.ok().body(
                    SuccessResponseBody
                            .<List<StoreBriefInfoResponse>>builder()
                            .status(HttpStatus.OK)
                            .message("Successfully found stores by user place")
                            .data(storeBriefInfosResponse)
                            .build()
            );

            return response;

        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                     ErrorResponseBody
                             .builder()
                             .status(HttpStatus.BAD_REQUEST.value())
                             .code(HttpStatus.BAD_REQUEST.name())
                             .message(e.getMessage() == null ? e.getMessage() : "Bad request" )
                             .error(e.getMessage())
                             .build()
             );
        }
    }

    @PostMapping("/word/stores")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 간단 정보 리스트",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })
    public ResponseEntity searchStoreByWord(@RequestBody SearchStoreByWordReqeust searchStoreByWordReqeust) {
        try {
            List<StoreBriefInfoResponse> storeBriefInfosResponse = new ArrayList();
//        List<StoreBriefInfoResponse> storeBriefInfosResponse =  searchService.

            ResponseEntity response =  ResponseEntity.ok().body(
                    SuccessResponseBody
                            .<List<StoreBriefInfoResponse>>builder()
                            .status(HttpStatus.OK)
                            .message("Successfully found stores by words")
                            .data(storeBriefInfosResponse)
                            .build()
            );

            return response;

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ErrorResponseBody
                            .builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .code(HttpStatus.BAD_REQUEST.name())
                            .message(e.getMessage() == null ? e.getMessage() : "Bad request" )
                            .error(e.getMessage())
                            .build()
            );
        }
    }

    @PostMapping("/category/stores")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 간단 정보 리스트",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })
    public ResponseEntity searchStoreByCategory(@RequestBody SearchStoreByCategoryReqeust req) {
        try {
            List<StoreBriefInfo> result = searchService.SearchCategory(req.getStoreType(),
                    req.getAddress(),req.getPage());

            StoreBriefInfoResponse filter;
            List<StoreBriefInfoResponse> responses = new ArrayList<>();

            for (int i = 0; i < result.size(); i++) {
                filter = new StoreBriefInfoResponse(result.get(i));
                responses.add(filter);
            }
            System.out.println(responses.size());

            ResponseEntity response =  ResponseEntity.ok().body(
                    SuccessResponseBody
                            .<List<StoreBriefInfoResponse>>builder()
                            .status(HttpStatus.OK)
                            .message("Successfully found stores by category")
                            .data(responses)
                            .build()
            );

            return response;

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ErrorResponseBody
                            .builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .code(HttpStatus.BAD_REQUEST.name())
                            .message(e.getMessage() == null ? e.getMessage() : "Bad request" )
                            .error(e.getMessage())
                            .build()
            );
        }
    }


    @PostMapping("/map/stores")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 간단 정보 리스트",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponse.class)))
            )
    })
    public ResponseEntity searchStoreByMap(@RequestBody SearchStoreByMapReqeust searchStoreByMapReqeust) {
        try {
        List<StoreBriefInfoResponse> storeBriefInfosResponse =  searchService.searchStoreByMap(searchStoreByMapReqeust);

            ResponseEntity response =  ResponseEntity.ok().body(
                    SuccessResponseBody
                            .<List<StoreBriefInfoResponse>>builder()
                            .status(HttpStatus.OK)
                            .message("Successfully found stores by map")
                            .data(storeBriefInfosResponse)
                            .build()
            );

            return response;

        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        ErrorResponseBody
                                .builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .code(HttpStatus.NOT_FOUND.name())
                                .message(e.getMessage() == null ? e.getMessage() : "Not Found" )
                                .error(e.getMessage())
                                .build()
                );
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ErrorResponseBody
                            .builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .code(HttpStatus.BAD_REQUEST.name())
                            .message(e.getMessage() == null ? e.getMessage() : "Bad request" )
                            .error(e.getMessage())
                            .build()
            );
        }
    }
}