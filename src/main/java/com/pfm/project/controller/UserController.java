//package com.pfm.project.controller;
//
//import com.pfm.project.vo.TestVO;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping(value = "/index")
//@Tag(name = "Test", description = "Test Api Document")
//public class UserController {
//
//    @GetMapping("/main")
//    @Operation(summary = "메인화면",description = "메인화면 출력", tags = {"태그 분리방식1"})
//    public String MainView(){
//        return "";
//    }
//    @Tag(name="태그 분리방식2")
//    @Operation(summary = "put test api summary", description = "[@Operation] put test api")
//    @PutMapping("/put")
//    public String putTest3() {
//        return "hi";
//    }
//
//    @Operation(summary = "get 방식 api summary", description = "[@Operation] get test api")
//    @GetMapping("/get/{id}")
//    public String getTest1( ) {
//        return "get id test";
//    }
//
//    @Operation(summary = "post test api summary", description = "[@Operation] post test api")
//    @PostMapping("/post")
//    public String postTest2() {
//        return "예시";
//    }
//
//
//
//    @Operation(summary = "delete test api summary", description = "[@Operation] delete test api")
//    @DeleteMapping("/delete")
//    public String deleteTest4() {
//        return "hi";
//    }
//
//
//
//}