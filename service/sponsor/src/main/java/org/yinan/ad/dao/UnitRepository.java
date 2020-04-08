package org.yinan.ad.dao;

import org.yinan.ad.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit findByPlanIdAndUnitName(Long planId, String unitName);
    List<Unit> findAllByUnitStatus(Integer unitStatus);
}
