package com.smk.store.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.store.dto.StoreDTO;
import com.smk.store.dto.StoresDTO;
import com.smk.store.model.Store;
import com.smk.store.repository.StoreRepository;
import com.smk.store.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private ModelMapper modelMapper;// = new ModelMapper();

	@Override
	public StoresDTO getAllStore() {

//		return ((List<Store>) storeRepository.findAll()).stream()
//				.map(s -> modelMapper.map(s, StoreDTO.class)).collect(Collectors.toList());

		System.out.println("====================================");
//		System.out.println("--------db data---------");
//		List<Store> ll = (List<Store>) storeRepository.findAll();
//		List<StoreDTO> ds = new ArrayList<>();
//		for (Store l : ll) {
//			System.out.println(l);
//			StoreDTO d = modelMapper.map(l, StoreDTO.class);
//			StoreDTO d1 = new StoreDTO();
//			BeanUtils.copyProperties(l, d1);
//			System.out.println(d);
//			ds.add(d1);
//		}
//		System.out.println("--------test data---------");
//		System.out.println(ds.get(0));
//		System.out.println(ds.get(1));
//		System.out.println("**************************************");
//		ll = createStores2Records();
//		ds = new ArrayList<>();
//		for (Store l : ll) {
//			System.out.println(l);
//			StoreDTO d = modelMapper.map(l, StoreDTO.class);
//			System.out.println(d);
//			ds.add(d);
//		}
//		System.out.println("-----------------");
//		System.out.println(ds.get(0));
//		System.out.println(ds.get(1));
//		System.out.println("-----------------");
//		System.out.println("====================================");
		List<StoreDTO> storeDtos = ((List<Store>) storeRepository.findAll()).stream()
				.map(o -> modelMapper.map(o, StoreDTO.class)).collect(Collectors.toList());

		StoresDTO store = new StoresDTO();
		store.setStoreDtos((storeDtos));
		return store;
	}

	@Override
	public StoresDTO getStoreById(long storeId) {
		Store store = storeRepository.findById(storeId).get();
		List<StoreDTO> storeDtos = new ArrayList();
		storeDtos.add(modelMapper.map(store, StoreDTO.class));
		StoresDTO stores = new StoresDTO();
		stores.setStoreDtos(storeDtos);
		;
		return stores;

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
