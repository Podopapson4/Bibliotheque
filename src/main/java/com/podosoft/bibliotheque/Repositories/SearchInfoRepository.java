package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.SearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchInfoRepository extends JpaRepository<SearchInfo, Long> {
}
