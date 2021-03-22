package com.smk.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.inventory.dto.InventoryDTO;
import com.smk.inventory.exception.RecordNotFoundException;
import com.smk.inventory.models.Inventory;
import com.smk.inventory.repository.InventoryRepository;
import com.smk.inventory.service.InventoryService;

import javassist.NotFoundException;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<InventoryDTO> listAll() {

//		((List<Inventory>) inventoryRepository.findAll()).stream().
		List<InventoryDTO> inventoryDtos = ((List<Inventory>) inventoryRepository.findAll()).stream()
				.map(InventoryDTO::new).collect(Collectors.toList());
		return inventoryDtos;

	}

	@Override
	public InventoryDTO get(Long inventoryId) {

		Inventory inventory = getInventory(inventoryId);
//		Inventory inventory = inventoryRepository.findById(inventoryId).get();
		return new InventoryDTO(inventory);
	}

	private Inventory getInventory(Long inventoryId) {
		Inventory inventory = inventoryRepository.findById(inventoryId)
				.orElseThrow(() -> new RecordNotFoundException(inventoryId));
		return inventory;
	}

	@Override
	public void save(Inventory inventory) {
		inventoryRepository.save(inventory);
	}

	@Override
	public Inventory update(Inventory inventory) {
		getInventory(inventory.getInventoryId());
		
		return inventoryRepository.save(inventory);
	}

	@Override
	public void delete(Long inventoryId) {
		Inventory inventory = getInventory(inventoryId);
		inventoryRepository.delete(inventory);
	}

}