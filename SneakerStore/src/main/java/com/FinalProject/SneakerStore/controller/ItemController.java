package com.FinalProject.SneakerStore.controller;

import com.FinalProject.SneakerStore.controller.dto.ItemDTO;
import com.FinalProject.SneakerStore.repository.Item;
import com.FinalProject.SneakerStore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FinalProject.SneakerStore.repository.ItemRepository;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;


    public ItemController(@Autowired ItemRepository itemRepository, ItemService itemService ) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

    @PostMapping
    public void save( @RequestBody ItemDTO itemDto )
    {
        itemService.save( itemDto );
    }

    @GetMapping("/{id}")
    public Optional<Item> findItemById(@PathVariable Integer id ){
        return itemService.findById( id );
    }

    @PutMapping
    public void update(@RequestBody Item newItem) {
        itemService.update(newItem);
    }

    @PutMapping( "/{id}" )
    public void update(@RequestBody ItemDTO itemDto, @PathVariable Integer id )
    {
        itemService.update(id, itemDto );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}
