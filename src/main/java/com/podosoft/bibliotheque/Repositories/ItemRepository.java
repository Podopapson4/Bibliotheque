package com.podosoft.bibliotheque.Repositories;

import com.podosoft.bibliotheque.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
