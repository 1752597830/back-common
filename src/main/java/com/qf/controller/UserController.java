package com.qf.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : sin
 * @date : 2023/11/30 23:04
 * @Description :
 */
@RestController
@Tag(name = "测试接口文档")
public class UserController {

    @Operation(summary = "普通body请求")
    @PostMapping("/body")
    public ResponseEntity body(@RequestBody Object fileResp){
        return ResponseEntity.ok(fileResp);
    }
    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("fileResp");
    }

}