package org.yinan.ad.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yinan.ad.annotation.IgnoreResponseAdvice;
import org.yinan.ad.client.SponsorClient;
import org.yinan.ad.client.vo.Plan;
import org.yinan.ad.client.vo.PlanGetRequest;
import org.yinan.ad.vo.CommonResponse;

import java.util.List;

@Slf4j
@RestController
public class SearchController {
    private final RestTemplate restTemplate;

    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate, SponsorClient sponsorClient) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @IgnoreResponseAdvice
    @PostMapping("/getPlans")
    public CommonResponse<List<Plan>> getPlans(@RequestBody PlanGetRequest request) {
        log.info("search: getPlans -> {}",
                JSON.toJSONString(request));
        return sponsorClient.getPlans(request);
    }

    @IgnoreResponseAdvice
    @PostMapping("/getPlanByRibbon")
    public CommonResponse<List<Plan>> getPlanByRibbon(@RequestBody PlanGetRequest request) {
        log.info("search: getPlanByRibbon -> {}",
                JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-sponsor/sponsor/get/plan",
                request,
                CommonResponse.class
        ).getBody();
    }
}
