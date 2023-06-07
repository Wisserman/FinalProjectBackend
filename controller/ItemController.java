package com.FinalProject.SneakerStore.controller;

import com.FinalProject.SneakerStore.repository.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.FinalProject.SneakerStore.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class ItemController {
    final ItemRepository itemRepository;


    public ItemController(@Autowired ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDto) {
        //convert the itemDto to item
        Item newItem = convertToItem(itemDto);

        return Response.Entity.status(HttpStatus.Created).body(newItem);
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
        return itemService.save( new Item( itemDto ) );
    }

    @GetMapping("/{id}")
    public Item findItemById( @PathVariable Integer id ){
        return itemService.findById( id );
    }

    @PutMapping( "/{id}" )
    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
        Item item = itemService.findById( id );
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        return itemService.save( item );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}
