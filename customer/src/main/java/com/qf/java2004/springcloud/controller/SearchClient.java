package com.qf.java2004.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SEARCH") //指定服务名称
public interface SearchClient {
    //    value ->目标服务的请求路径,method -> 映射请求方式
    @RequestMapping(value = "/hij", method = RequestMethod.GET)
    String search();
}
