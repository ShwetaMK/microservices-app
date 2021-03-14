package com.smk.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.inventory.models.Inventory;
import com.smk.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	//Get List of All inventory items 
	public List<Inventory> getAllInventory() {		
		return (List<Inventory>) inventoryRepository.findAll();
	}
	
	//Search Inventory item by using Id
	public Inventory getInventoryById(long inventoryId) {		
		return inventoryRepository.findById(inventoryId).get();
	}

	//Add item into Inventory
	public Inventory addInventory(Inventory inventory) {	
		return inventoryRepository.save(inventory);
	}

	//Update Inventory item information
	public Inventory updateInventory(long inventoryId,Inventory inventory) {
		Inventory oldInventory=inventoryRepository.findById(inventoryId).get();
		oldInventory.setInventoryName(inventory.getInventoryName());
		oldInventory.setInventoryQuantity(inventory.getInventoryQuantity());
		return inventoryRepository.save(oldInventory);
	}

	//Delete inventory item
	public String deleteInventoryById(long inventoryId) {
		inventoryRepository.deleteById(inventoryId);
		return "deleted successfully";		
	}
	
}