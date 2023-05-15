package com.pfm.project.controller;

import com.pfm.project.dto.store_detail.StoreDetailResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Store", description = "업소 관련 api")
public class StoreController {

    @GetMapping("/detail/{storeId}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "업소 정보",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StoreDetailResponseDTO.class))
            ),
    })
    @Operation(summary = "회원 조회", description = "id를 이용하여 user 레코드를 조회합니다.")
    public HomeCardResponse findStoreDetail(@PathVariable int storeId) {
        return null;
        //        return  storeDetailResponseDTO;
    }
}
