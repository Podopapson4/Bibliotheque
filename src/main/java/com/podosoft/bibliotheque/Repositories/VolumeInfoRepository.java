package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.VolumeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeInfoRepository extends JpaRepository<VolumeInfo, Long> {
}
