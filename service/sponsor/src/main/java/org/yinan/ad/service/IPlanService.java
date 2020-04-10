package org.yinan.ad.service;

import org.yinan.ad.exception.AdException;
import org.yinan.ad.entity.Plan;
import org.yinan.ad.vo.PlanGetRequest;
import org.yinan.ad.vo.PlanRequest;
import org.yinan.ad.vo.PlanResponse;

import java.util.List;

public interface IPlanService {
    PlanResponse createPlan(PlanRequest request) throws AdException;
    List<Plan> getPlanByIds(PlanGetRequest request) throws AdException;
    PlanResponse updatePlan(PlanRequest request) throws AdException;
    void deletePlan(PlanRequest request) throws AdException;
}
