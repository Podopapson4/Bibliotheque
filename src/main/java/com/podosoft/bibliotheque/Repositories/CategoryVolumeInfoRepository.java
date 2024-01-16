package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.Joined.CategoryVolumeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryVolumeInfoRepository extends JpaRepository<CategoryVolumeInfo, Long> {
}
