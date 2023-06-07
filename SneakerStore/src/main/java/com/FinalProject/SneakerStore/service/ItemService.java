package com.FinalProject.SneakerStore.service;



import com.FinalProject.SneakerStore.repository.Item;

import java.util.List;
import java.util.Optional;


public interface ItemService
{

    Item save(Item item );

    void delete( int itemId );

    List<Item> all();

    Optional<Item> findById(int itemId );

}