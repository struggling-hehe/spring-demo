package com.clear.consumer.controller;

import com.clear.consumer.feign.TestFeign;
import com.clear.consumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private TestService paymentService;


    @RequestMapping("/hello")
    public String hello() {
        return testFeign.test();
    }


    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return testFeign.paymentInfo_OK(id);
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return testFeign.paymentInfo_TimeOut(id);

    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        System.out.println("****result: " + result);
        return result;
    }


}
