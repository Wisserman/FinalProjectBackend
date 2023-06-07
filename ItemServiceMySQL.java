package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Item;
import repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySQL
        implements ItemService
{
    private final ItemRepository itemRepository;

    public ItemServiceMySQL( @Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item )
    {
        return itemRepository.save( item );
    }

    @Override
    public void delete( int itemId )
    {
        itemRepository.deleteById( itemId );
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Optional<Item> findById(int itemId )
    {
        return itemRepository.findById(itemId);
    }
}
