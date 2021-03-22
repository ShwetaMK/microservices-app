package com.smk.inventory.service;

import java.util.List;

import com.smk.inventory.dto.InventoryDTO;
import com.smk.inventory.models.Inventory;

import javassist.NotFoundException;

public interface InventoryService {

	List<InventoryDTO> listAll();

	InventoryDTO get(Long inventoryId);

	void save(Inventory inventory);

	Inventory update(Inventory inventory);

	void delete(Long inventoryId);

}