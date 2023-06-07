package com.FinalProject.SneakerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Override
    public List<Item> findAll();
}
