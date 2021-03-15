package com.smk.store.service;

import java.util.List;

import com.smk.store.dto.StoreDTO;
import com.smk.store.model.Store;

public interface StoreService {

	// Get List of All store items
	public List<StoreDTO> getAllStore();

	// Search Store item by using Id
	public StoreDTO getStoreById(long storeId);

	// Add item into Store
	public StoreDTO addStore(Store store);

	// Update Store item information
	public StoreDTO updateStore(long storeId, Store store);

	// Delete store item
	public String deleteStoreById(long storeId);

}
