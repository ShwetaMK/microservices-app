package com.smk.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.inventory.dto.InventoryDTO;
import com.smk.inventory.exception.RecordNotFoundException;
import com.smk.inventory.models.Inventory;
import com.smk.inventory.repository.InventoryRepository;
import com.smk.inventory.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<InventoryDTO> listAll() {

		List<InventoryDTO> inventoryDtos = ((List<Inventory>) inventoryRepository.findAll()).stream()
				.map(InventoryDTO::new).collect(Collectors.toList());
		return inventoryDtos;

	}

	@Override
	public InventoryDTO get(Long inventoryId) {

		return new InventoryDTO(getInventory(inventoryId));
	}

	private Inventory getInventory(Long inventoryId) {
		Inventory inventory = inventoryRepository.findById(inventoryId)
				.orElseThrow(() -> new RecordNotFoundException(inventoryId));
		return inventory;
	}

	@Override
	public InventoryDTO save(Inventory inventory) {
		Inventory inv = inventoryRepository.save(inventory);
		return new InventoryDTO(inv);
	}

	@Override
	public InventoryDTO update(Inventory inventory) {
		getInventory(inventory.getInventoryId());

		Inventory inv = inventoryRepository.save(inventory);
		return new InventoryDTO(inv);
	}

	@Override
	public void delete(Long inventoryId) {
		Inventory inventory = getInventory(inventoryId);
		inventoryRepository.delete(inventory);
	}
}