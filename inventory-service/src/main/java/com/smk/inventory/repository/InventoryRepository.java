package com.smk.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smk.inventory.models.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

}
