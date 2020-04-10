package org.yinan.ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yinan.ad.dao.CreativeRepository;
import org.yinan.ad.entity.Creative;
import org.yinan.ad.service.ICreativeService;
import org.yinan.ad.vo.CreativeRequest;
import org.yinan.ad.vo.CreativeResponse;

@Service
public class CreativeServiceImpl implements ICreativeService {
    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
