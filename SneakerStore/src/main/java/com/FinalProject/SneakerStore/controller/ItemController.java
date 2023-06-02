package com.FinalProject.SneakerStore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepo) {
        itemRepository = itemRepo;
    }

    @GetMapping
    public Iterable<Item> getItems() {
        return itemRepository.getAll();
    }

    @GetMapping("/${id}")
    public Item getItem(int id) {
        return itemRepository.getItem(id);
    }
}
