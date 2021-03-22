package com.smk.inventory.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smk.inventory.dto.InventoryDTO;
import com.smk.inventory.models.Inventory;
import com.smk.inventory.service.InventoryService;

@RestController
@RequestMapping("inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

//	@GetMapping
//	public InventoriesDTO getAllInventory() {
//		return inventoryService.listAll();
//
//	}
//
//	@GetMapping("/{inventoryId}")
//	public InventoriesDTO getInventoryByid(@PathVariable Long inventoryId) {
//		return inventoryService.get(inventoryId);
//
//	}

	@GetMapping
	public ResponseEntity<List<InventoryDTO>> getAllInventory() {

		List<InventoryDTO> inventory = inventoryService.listAll();
		if (inventory.isEmpty()) {
//			throw new NoContentException();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(inventory, HttpStatus.OK);

	}

	@GetMapping("/{inventoryId}")
	public ResponseEntity<InventoryDTO> getInventoryByid(@Valid @PositiveOrZero @PathVariable Long inventoryId) {
		return new ResponseEntity<>(inventoryService.get(inventoryId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addInventory(@Valid @RequestBody Inventory inventory, Errors errors) {
//		return ResponseEntity.status(HttpStatus.CREATED);
		if (errors.hasErrors()) {
			System.out.println(errors);
		}
		inventoryService.save(inventory);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.update(inventory), HttpStatus.OK);

	}

	@DeleteMapping("{inventoryId}")
	public ResponseEntity<?> deleteInventoryById(
			@Valid @PathVariable @PositiveOrZero BigInteger inventoryId) {
//		Long i =  Long.bi inventoryId;
//		inventoryService.delete(inventoryId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}