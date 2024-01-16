package com.podosoft.bibliotheque.Services.Impl;

import com.podosoft.bibliotheque.Models.SaleInfo;
import com.podosoft.bibliotheque.Repositories.SaleInfoRepository;
import com.podosoft.bibliotheque.Services.SaleInfoService;
import org.springframework.stereotype.Service;

@Service
public class SaleInfoServiceImpl implements SaleInfoService {
    final SaleInfoRepository saleInfoRepository;

    public SaleInfoServiceImpl(SaleInfoRepository saleInfoRepository) {
        this.saleInfoRepository = saleInfoRepository;
    }

    @Override
    public SaleInfo save(SaleInfo saleInfo) {
        return saleInfoRepository.save(saleInfo);
    }
}
