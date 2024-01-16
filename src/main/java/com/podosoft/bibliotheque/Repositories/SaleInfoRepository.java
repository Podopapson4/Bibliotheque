package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.SaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleInfoRepository extends JpaRepository<SaleInfo, Long> {
}
