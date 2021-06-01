package com.clear.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jiexipeng
 * @date 2021/06/01
 */
@FeignClient("service-producer")
public interface TestFeign {

    @GetMapping("/hello")
    public String test();
}
