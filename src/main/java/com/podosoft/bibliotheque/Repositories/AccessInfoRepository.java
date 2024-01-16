package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.AccessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessInfoRepository extends JpaRepository<AccessInfo, Long> {
}
