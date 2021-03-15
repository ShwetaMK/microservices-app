package com.smk.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.smk.store.dto.StoreDTO;
import com.smk.store.model.Store;
import com.smk.store.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {

	@Autowired
	StoreService storeService;

	@GetMapping
	public ResponseEntity<List<StoreDTO>> getAllStore() {
		return ResponseEntity.status(HttpStatus.OK).body(storeService.getAllStore());

	}

	@GetMapping("/{storeId}")
	public ResponseEntity<StoreDTO> getStoreByid(@PathVariable int storeId) throws NotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(storeService.getStoreById(storeId));

	}

	@PostMapping
	public ResponseEntity<StoreDTO> addStore(@RequestBody Store store) {
		return ResponseEntity.status(HttpStatus.OK).body(storeService.addStore(store));

	}

	@PutMapping("{storeId}")
	public ResponseEntity<StoreDTO> updateStore(@PathVariable int storeId, @RequestBody Store store) {
		return ResponseEntity.status(HttpStatus.OK).body(storeService.updateStore(storeId, store));

	}

	@DeleteMapping("{storeId}")
	public ResponseEntity<String> deleteStoreById(@PathVariable int storeId) {

		return ResponseEntity.status(HttpStatus.OK).body(storeService.deleteStoreById(storeId));

	}
}
