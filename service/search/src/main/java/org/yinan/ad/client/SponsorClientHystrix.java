package org.yinan.ad.client;

import org.springframework.stereotype.Component;
import org.yinan.ad.client.vo.Plan;
import org.yinan.ad.client.vo.PlanGetRequest;
import org.yinan.ad.vo.CommonResponse;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse<List<Plan>> getPlans(PlanGetRequest request) {
        return new CommonResponse<>(-1, "eureka-client-sponsor error");
    }
}
