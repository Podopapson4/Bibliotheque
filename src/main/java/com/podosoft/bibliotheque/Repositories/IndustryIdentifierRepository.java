package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.IndustryIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryIdentifierRepository extends JpaRepository<IndustryIdentifier, Long> {
}
