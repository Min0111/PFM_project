package com.pfm.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@Schema(description = "UserController Test 관련 VO")
public class TestVO {
    @Schema(description = "유저아이디", example = "1")
    String userId;

    @NotNull
    @Schema(description = "유저패스워드", example = "1234")
    String password;

    @Null
    @Schema(description = "유저메모", example = "메모")
    String memo;

    @Schema(description = "테스트 숫자", example = "22", maximum = "50")
    Long testNum;
}