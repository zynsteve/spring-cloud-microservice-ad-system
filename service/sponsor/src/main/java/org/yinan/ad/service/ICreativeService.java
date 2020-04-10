package org.yinan.ad.service;

import org.yinan.ad.vo.CreativeRequest;
import org.yinan.ad.vo.CreativeResponse;

public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
