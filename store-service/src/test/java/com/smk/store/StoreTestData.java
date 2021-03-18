package com.smk.store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.smk.store.dto.StoreDTO;
import com.smk.store.model.Store;

public class StoreTestData {

	public StoreTestData() {
	}

	
	public static Store createStore_1() {
		Store s1 = new Store();
		s1.setCreateTime(LocalDateTime.now());
		s1.setStoreId(1l);
		s1.setStoreName("Store 1");
		s1.setStoreQuantity(12);
		return s1;
	}

	public static Store createStore_2() {
		Store s1 = new Store();
		s1.setCreateTime(LocalDateTime.now());
		s1.setStoreId(2l);
		s1.setStoreName("Store 2");
		s1.setStoreQuantity(22);
		return s1;
	}

	public static List<Store> createStores2Records() {
		List<Store> stores = new ArrayList<>();
		stores.add(createStore_1());
		stores.add(createStore_2());
		return stores;
	}
	public static StoreDTO createStoreDTO_1() {
		StoreDTO s1 = new StoreDTO();
		s1.setCreateTime(LocalDateTime.now());
		s1.setStoreId(1l);
		s1.setStoreName("Store 1");
		s1.setStoreQuantity(12);
		return s1;
	}

	public static StoreDTO createStoreDTO_2() {
		StoreDTO s1 = new StoreDTO();
		s1.setCreateTime(LocalDateTime.now());
		s1.setStoreId(2l);
		s1.setStoreName("Store 2");
		s1.setStoreQuantity(22);
		return s1;
	}

	public static List<StoreDTO> createStoresDTOSingleEntry() {
		List<StoreDTO> stores = new ArrayList<>();
		stores.add(createStoreDTO_1());
		return stores;
	}

	public static List<StoreDTO> createStoresDTO2Records() {
		List<StoreDTO> stores = new ArrayList<>();
		stores.add(createStoreDTO_1());
		stores.add(createStoreDTO_2());
		return stores;
	}

}