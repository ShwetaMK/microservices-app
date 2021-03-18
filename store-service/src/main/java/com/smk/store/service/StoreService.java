package com.smk.store.service;

import com.smk.store.dto.StoreDTO;
import com.smk.store.dto.StoresDTO;
import com.smk.store.model.Store;

public interface StoreService {

	// Get List of All store items
	public StoresDTO getAllStore();

	// Search Store item by using Id
	public StoresDTO getStoreById(long storeId);

	// Add item into Store
	public StoreDTO addStore(Store store);

	// Update Store item information
	public StoreDTO updateStore(long storeId, Store store);

	// Delete store item
	public String deleteStoreById(long storeId);

}
