package org.example.server.controller;

import org.example.server.result.Result;
import org.example.server.result.ResultFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/15
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Result hello(){
        return ResultFactory.buildSuccessResult("Hello World");
    }
}
