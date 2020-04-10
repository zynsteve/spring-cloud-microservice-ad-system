package org.yinan.ad.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yinan.ad.entity.Plan;
import org.yinan.ad.exception.AdException;
import org.yinan.ad.service.IPlanService;
import org.yinan.ad.vo.PlanGetRequest;
import org.yinan.ad.vo.PlanRequest;
import org.yinan.ad.vo.PlanResponse;

import java.util.List;

@Slf4j
@RestController
public class PlanOPController {

    private final IPlanService planService;

    @Autowired
    public PlanOPController(IPlanService adPlanService) {
        this.planService = adPlanService;
    }

    @PostMapping("/create/plan")
    public PlanResponse createAdPlan(@RequestBody PlanRequest request) throws AdException {
        log.info("sponsor: createPlan -> {}",
                JSON.toJSONString(request));
        return planService.createPlan(request);
    }

    @PostMapping("/get/plan")
    public List<Plan> getAdPlanByIds(@RequestBody PlanGetRequest request) throws AdException {
        log.info("sponsor: getPlanByIds -> {}",
                JSON.toJSONString(request));
        return planService.getPlanByIds(request);
    }

    @PutMapping("/update/plan")
    public PlanResponse updateAdPlan(@RequestBody PlanRequest request) throws AdException {
        log.info("sponsor: updatePlan -> {}",
                JSON.toJSONString(request));
        return planService.updatePlan(request);
    }

    @DeleteMapping("/delete/plan")
    public void deleteAdPlan(@RequestBody PlanRequest request) throws AdException {
        log.info("sponsor: deletePlan -> {}",
                JSON.toJSONString(request));
        planService.deletePlan(request);
    }
}
