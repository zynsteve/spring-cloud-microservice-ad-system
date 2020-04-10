package org.yinan.ad.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yinan.ad.client.vo.Plan;
import org.yinan.ad.client.vo.PlanGetRequest;
import org.yinan.ad.vo.CommonResponse;

import java.util.List;

@FeignClient(value = "eureka-client-sponsor", fallback = SponsorClientHystrix.class)
public interface SponsorClient {
    @RequestMapping(value = "/sponsor/get/plan", method = RequestMethod.POST)
    CommonResponse<List<Plan>> getPlans(@RequestBody PlanGetRequest request);
}
