package com.clear.producer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jiexipeng
 * @date 2021/06/02
 */
@Service
public class TestService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHabdler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {

//        try {
//            // 暂停2秒钟
//            TimeUnit.MILLISECONDS.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int age = 10 / 0;
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)";
    }

    /**
     * 超时访问到这里兜底
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHabdler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOutHabdler,id:" + id + "\t" +
                "系统繁忙，请稍后再试****o(╥﹏╥)o";
    }



}
