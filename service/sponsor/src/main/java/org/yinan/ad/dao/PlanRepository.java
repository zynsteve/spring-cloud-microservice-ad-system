package org.yinan.ad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yinan.ad.entity.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Plan findByIdAndUserId(Long id, Long userId);
    List<Plan> findAllByIdAndUserId(List<Long> ids, Long userId);
    Plan findByUserIdAndPlanName(Long userId, String planName);
    List<Plan> findAllByPlanStatus(Integer status);
}
