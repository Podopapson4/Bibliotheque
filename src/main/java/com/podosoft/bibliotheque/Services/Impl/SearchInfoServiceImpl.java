package com.podosoft.bibliotheque.Services.Impl;

import com.podosoft.bibliotheque.Models.SearchInfo;
import com.podosoft.bibliotheque.Repositories.SearchInfoRepository;
import com.podosoft.bibliotheque.Services.SearchInfoService;
import org.springframework.stereotype.Service;

@Service
public class SearchInfoServiceImpl implements SearchInfoService {
    final SearchInfoRepository searchInfoRepository;

    public SearchInfoServiceImpl(SearchInfoRepository searchInfoRepository) {
        this.searchInfoRepository = searchInfoRepository;
    }

    @Override
    public SearchInfo save(SearchInfo searchInfo) {
        return searchInfoRepository.save(searchInfo);
    }
}
