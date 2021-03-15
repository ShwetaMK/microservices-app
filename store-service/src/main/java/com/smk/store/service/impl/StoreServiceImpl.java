package com.smk.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.store.dto.StoreDTO;
import com.smk.store.model.Store;
import com.smk.store.repository.StoreRepository;
import com.smk.store.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<StoreDTO> getAllStore() {
		return ((List<Store>) storeRepository.findAll()).stream()
				.map(s -> modelMapper.map(s, StoreDTO.class)).collect(Collectors.toList());
	}

	@Override
	public StoreDTO getStoreById(long storeId) {
		Store store = storeRepository.findById(storeId).get();
		return modelMapper.map(store, StoreDTO.class);
	}

	@Override
	public StoreDTO addStore(Store store) {
		Store s = storeRepository.save(store);
		return modelMapper.map(s, StoreDTO.class);
	}

	@Override
	public StoreDTO updateStore(long storeId, Store store) {
		Store oldStore = storeRepository.findById(storeId).get();
		oldStore.setStoreName(store.getStoreName());
		oldStore.setStoreQuantity(store.getStoreQuantity());
		
		Store s = storeRepository.save(oldStore);
		return modelMapper.map(store, StoreDTO.class);
	}

	@Override
	public String deleteStoreById(long storeId) {
		storeRepository.deleteById(storeId);
		return "deleted successfully";
	}

}
