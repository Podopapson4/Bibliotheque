package com.podosoft.bibliotheque.Services.Impl;

import com.podosoft.bibliotheque.Models.Item;
import com.podosoft.bibliotheque.Repositories.ItemRepository;
import com.podosoft.bibliotheque.Services.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
