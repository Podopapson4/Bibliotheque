package com.podosoft.bibliotheque.Services;

import com.podosoft.bibliotheque.Models.VolumeInfo;

import java.util.List;

public interface VolumeInfoService {
    VolumeInfo save(VolumeInfo volumeInfo);

    List<VolumeInfo> getVolumeInfoPage(int pageNum, int pageSize);
}
