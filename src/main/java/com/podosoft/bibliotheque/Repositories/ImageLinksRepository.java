package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.ImageLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageLinksRepository extends JpaRepository<ImageLinks, Long> {

    Optional<ImageLinks> findTopByVolumeInfoId(Long volumeId);
}
