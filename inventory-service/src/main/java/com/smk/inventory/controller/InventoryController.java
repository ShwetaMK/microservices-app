package com.smk.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smk.inventory.models.Inventory;
import com.smk.inventory.service.InventoryService;

@RestController
@RequestMapping("inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@GetMapping
	public ResponseEntity<List<Inventory>> getAllInventory() {
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getAllInventory());

	}

	@GetMapping("/{inventoryId}")
	public ResponseEntity<Inventory> getInventoryByid(@PathVariable int inventoryId) {
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventoryById(inventoryId));

	}

	@PostMapping
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.addInventory(inventory));

	}

	@PutMapping("{inventoryId}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable int inventoryId, @RequestBody Inventory inventory) {
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.updateInventory(inventoryId, inventory));

	}

	@DeleteMapping("{inventoryId}")
	public ResponseEntity<String> deleteInventoryById(@PathVariable int inventoryId) {
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.deleteInventoryById(inventoryId));

	}

}