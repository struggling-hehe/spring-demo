package com.clear.consumer.controller;

import com.clear.consumer.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiexipeng
 * @date 2021/06/01
 */
@RestController
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @RequestMapping("/hello")
    public String hello() {
        return testFeign.test();
    }
}
