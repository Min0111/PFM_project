package com.pfm.project.controller;

import com.pfm.project.dto.searchStoreByMapReqeustDTO;
import com.pfm.project.dto.store.StoreBriefInfoResponseDTO;
import com.pfm.project.dto.store.StoreDetailResponseDTO;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Store", description = "업소 관련 api")
public class StoreController {

    @PostMapping("/stores/search")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 간단 정보 리스트",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponseDTO.class)))
            )
    })
    public ResponseEntity findStoreBriefInfos(@RequestBody searchStoreByMapReqeustDTO findByLocationRequestDTO) {
//        Pageable page = new Pageable.ofSize(20);
        return null;
    }

    @PostMapping("/stores/map")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 간단 정보 리스트",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StoreBriefInfoResponseDTO.class)))
            )
    })
    public List<StoreBriefInfoResponseDTO> searchStoreByMap(@RequestBody searchStoreByMapReqeustDTO findByLocationRequestDTO) {
        return null;
    }

    @GetMapping("/detail/{storeId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 정보",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StoreDetailResponseDTO.class))
            ),
    })

    public StoreDetailResponseDTO findStoreDetail(@PathVariable int storeId) {
        return null;
        //        return  storeDetailResponseDTO;
    }
}
