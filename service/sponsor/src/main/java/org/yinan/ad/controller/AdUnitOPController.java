package org.yinan.ad.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yinan.ad.exception.AdException;
import org.yinan.ad.service.IUnitService;
import org.yinan.ad.vo.*;

@Slf4j
@RestController
public class AdUnitOPController {

    private final IUnitService unitService;

    @Autowired
    public AdUnitOPController(IUnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("/create/unit")
    public UnitResponse createUnit(@RequestBody UnitRequest request) throws AdException {
        log.info("sponsor: createUnit -> {}",
                JSON.toJSONString(request));
        return unitService.createUnit(request);
    }

    @PostMapping("/create/unitKeyword")
    public UnitKeywordResponse createUnitKeyword(@RequestBody UnitKeywordRequest request) throws AdException {
        log.info("sponsor: createUnitKeyword -> {}",
                JSON.toJSONString(request));
        return unitService.createUnitKeyword(request);
    }

    @PostMapping("/create/unitIt")
    public UnitItResponse createUnitIt(@RequestBody UnitItRequest request) throws AdException {
        log.info("sponsor: createUnitIt -> {}",
                JSON.toJSONString(request));
        return unitService.createUnitIt(request);
    }

    @PostMapping("/create/unitDistrict")
    public UnitDistrictResponse createUnitDistrict(@RequestBody UnitDistrictRequest request) throws AdException {
        log.info("sponsor: createUnitDistrict -> {}",
                JSON.toJSONString(request));
        return unitService.createUnitDistrict(request);
    }

    @PostMapping("/create/creativeUnit")
    public CreativeUnitResponse createCreativeUnit(@RequestBody CreativeUnitRequest request) throws AdException {
        log.info("sponsor: createCreativeUnit -> {}",
                JSON.toJSONString(request));
        return unitService.createCreativeUnit(request);
    }
}
