package com.smk.inventory.service;

import java.util.List;

import com.smk.inventory.dto.InventoryDTO;
import com.smk.inventory.models.Inventory;

public interface InventoryService {

	List<InventoryDTO> listAll();

	InventoryDTO get(Long inventoryId);

	InventoryDTO save(Inventory inventory);

	InventoryDTO update(Inventory inventory);

	void delete(Long inventoryId);

}