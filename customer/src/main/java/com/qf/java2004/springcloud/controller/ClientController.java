package com.qf.java2004.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping(value = "/customer")
//  通过eurekaclient获取到SEARCH服务的信息
    public String customer() {
        InstanceInfo info = eurekaClient.getNextServerFromEureka("SEARCH", false);
//        获取到访问的地址
        String homePageUrl = info.getHomePageUrl();
        System.out.println("homePageUrl = " + homePageUrl);
//        通过restTemplate访问
        String forObject = restTemplate.getForObject(homePageUrl + "/hij", String.class);
        System.out.println(forObject);
        return forObject;
    }

    @GetMapping(value = "/cus")
    public String cus() {
        return restTemplate.getForObject("http://SEARCH/hij", String.class);
    }

    @Autowired
    private SearchClient searchClient;

    @GetMapping(value = "/cust")
    public String cust() {
        return searchClient.search();
    }
}
