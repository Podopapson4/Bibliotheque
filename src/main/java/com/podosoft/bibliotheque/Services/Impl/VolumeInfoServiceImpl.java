package com.podosoft.bibliotheque.Services.Impl;

import com.podosoft.bibliotheque.Models.ImageLinks;
import com.podosoft.bibliotheque.Models.IndustryIdentifier;
import com.podosoft.bibliotheque.Models.Joined.AuthorVolumeInfo;
import com.podosoft.bibliotheque.Models.Joined.CategoryVolumeInfo;
import com.podosoft.bibliotheque.Models.VolumeInfo;
import com.podosoft.bibliotheque.Repositories.*;
import com.podosoft.bibliotheque.Services.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeInfoServiceImpl implements VolumeInfoService {
    final VolumeInfoRepository volumeInfoRepository;
    final AuthorVolumeInfoRepository authorVolumeInfoRepository;
    final IndustryIdentifierRepository industryIdentifierRepository;
    final CategoryVolumeInfoRepository categoryVolumeInfoRepository;
    final ImageLinksRepository imageLinksRepository;

    public VolumeInfoServiceImpl(VolumeInfoRepository volumeInfoRepository, AuthorVolumeInfoRepository authorVolumeInfoRepository, IndustryIdentifierRepository industryIdentifierRepository, CategoryVolumeInfoRepository categoryVolumeInfoRepository, ImageLinksRepository imageLinksRepository) {
        this.volumeInfoRepository = volumeInfoRepository;
        this.authorVolumeInfoRepository = authorVolumeInfoRepository;
        this.industryIdentifierRepository = industryIdentifierRepository;
        this.categoryVolumeInfoRepository = categoryVolumeInfoRepository;
        this.imageLinksRepository = imageLinksRepository;
    }


    @Override
    public VolumeInfo save(VolumeInfo volumeInfo) {
        VolumeInfo volumeInfoSaved = volumeInfoRepository.save(volumeInfo);
        volumeInfo.setId(volumeInfoSaved.getId());

        if (volumeInfo.getAuthors() != null) {
            for (String authorString : volumeInfo.getAuthors()) {
                AuthorVolumeInfo authorVolumeInfo = new AuthorVolumeInfo();
                authorVolumeInfo.setAuthorName(authorString);
                authorVolumeInfo.setVolumeInfoId(volumeInfoSaved.getId());
                authorVolumeInfoRepository.save(authorVolumeInfo);
            }
        }

        if (volumeInfo.getIndustryIdentifiers() != null) {
            for (IndustryIdentifier industryIdentifier : volumeInfo.getIndustryIdentifiers()) {
                industryIdentifier.setVolumeInfoId(volumeInfoSaved.getId());
                industryIdentifierRepository.save(industryIdentifier);
            }
        }

        if (volumeInfo.getCategories() != null) {
            for (String categoryString : volumeInfo.getCategories()) {
                CategoryVolumeInfo categoryVolumeInfo = new CategoryVolumeInfo();
                categoryVolumeInfo.setCategoryName(categoryString);
                categoryVolumeInfo.setVolumeInfoId(volumeInfoSaved.getId());
                categoryVolumeInfoRepository.save(categoryVolumeInfo);
            }
        }

        if (volumeInfo.getImageLinks() != null) {
            volumeInfo.getImageLinks().setVolumeInfoId(volumeInfoSaved.getId());
            ImageLinks imageLinks = imageLinksRepository.save(volumeInfo.getImageLinks());
        }

        return volumeInfoSaved;
    }

    @Override
    public List<VolumeInfo> getVolumeInfoPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        List<VolumeInfo> volumeInfoList = volumeInfoRepository.findAll(pageable).getContent();

        for (VolumeInfo volumeInfo : volumeInfoList){
            volumeInfo.setImageLinks(imageLinksRepository.findTopByVolumeInfoId(volumeInfo.getId()).orElse(null));
        }

        return volumeInfoList;
    }
}
