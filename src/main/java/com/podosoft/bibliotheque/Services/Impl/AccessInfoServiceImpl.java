package com.podosoft.bibliotheque.Services.Impl;

import com.podosoft.bibliotheque.Models.AccessInfo;
import com.podosoft.bibliotheque.Repositories.AccessInfoRepository;
import com.podosoft.bibliotheque.Services.AccessInfoService;
import org.springframework.stereotype.Service;

@Service
public class AccessInfoServiceImpl implements AccessInfoService {
    final AccessInfoRepository accessInfoRepository;

    public AccessInfoServiceImpl(AccessInfoRepository accessInfoRepository) {
        this.accessInfoRepository = accessInfoRepository;
    }

    @Override
    public AccessInfo save(AccessInfo accessInfo) {
        return accessInfoRepository.save(accessInfo);
    }
}
