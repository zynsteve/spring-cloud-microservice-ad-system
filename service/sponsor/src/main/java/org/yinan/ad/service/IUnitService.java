package org.yinan.ad.service;

import org.yinan.ad.exception.AdException;
import org.yinan.ad.vo.*;

public interface IUnitService {
    UnitResponse createUnit(UnitRequest request) throws AdException;
    UnitKeywordResponse createUnitKeyword(UnitKeywordRequest request) throws AdException;
    UnitItResponse createUnitIt(UnitItRequest request) throws AdException;
    UnitDistrictResponse createUnitDistrict(UnitDistrictRequest request) throws AdException;
    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;
}
