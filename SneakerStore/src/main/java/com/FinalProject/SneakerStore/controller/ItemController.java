package com.FinalProject.SneakerStore.controller;

import com.FinalProject.SneakerStore.controller.dto.ItemDto;
import com.FinalProject.SneakerStore.repository.Item;
import com.FinalProject.SneakerStore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.FinalProject.SneakerStore.repository.ItemRepository;

import java.util.Optional;

@RestController
@RequestMapping("/item")
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
    public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDto) {
        //convert the itemDto to item
        Item newItem = convertToItem(itemDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }
    // Helper method to convert ItemDto to Item
    private Item convertToItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());

        return item;
    }

    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.save( new Item() );
    }

    @GetMapping("/{id}")
    public Optional<Item> findItemById(@PathVariable Integer id ){
        return itemService.findById( id );
    }

    @PutMapping( "/{id}" )
    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
        Optional<Item> item = itemService.findById( id );
        item.get().setName( itemDto.getName() );
        item.get().setDescription( itemDto.getDescription() );
        item.get().setImageUrl( itemDto.getImageUrl() );
        return itemService.save( item.get() );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}
