package com.FinalProject.SneakerStore.service;



import com.FinalProject.SneakerStore.controller.dto.ItemDTO;
import com.FinalProject.SneakerStore.repository.Item;
import com.FinalProject.SneakerStore.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService
{
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item ) {
        itemRepository.save(item);
    }

    public void save(ItemDTO itemDto) {
        Item itemToSave = new Item();

        itemToSave.setName(itemDto.name());
        itemToSave.setDescription(itemDto.description());
        itemToSave.setImageUrl(itemDto.imageUrl());

        itemRepository.save(itemToSave);
    }
    public void delete( int itemId ) {
        itemRepository.deleteById(itemId);
    }

    public List<Item> all() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(int itemId ) {
        return itemRepository.findById(itemId);
    }

    public void update(Item item) {
        int id = item.getId();
        Item foundItem = itemRepository.findById(id).orElseThrow();
        foundItem.setName(item.getName());
        foundItem.setDescription(item.getDescription());
        foundItem.setImageUrl(item.getImageUrl());
        itemRepository.save(foundItem);
    }

    public void update(int id, ItemDTO item) {
        Item foundItem = itemRepository.findById(id).orElseThrow();
        foundItem.setName(item.name());
        foundItem.setDescription(item.description());
        foundItem.setImageUrl(item.imageUrl());
        itemRepository.save(foundItem);
    }

    public void save(Integer id, ItemDTO itemDto) {
    }
}