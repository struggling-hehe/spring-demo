package com.clear.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiexipeng
 * @date 2021/06/01
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "helle consul";
    }
}
