package com.smk.store.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.smk.store.StoreTestData;
import com.smk.store.dto.StoreDTO;
import com.smk.store.dto.StoresDTO;
import com.smk.store.repository.StoreRepository;
import com.smk.store.service.impl.StoreServiceImpl;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StoreServiceImplTest {

	@Mock
	private StoreRepository storeRepository;
	// ---------------
//	@Mock
//	@Autowired
//	@MockBean
//	private ModelMapper modelMapper = new ModelMapper();
//private ModelMapper modelMapper = modelmapp
	// ---------------
//	@Autowired
//	@MockBean
//	@Mock
	private ModelMapper modelMapper;
	// ---------------
	@InjectMocks
//	@Autowired
	private StoreServiceImpl storeService;

//	@Autowired

	@Before
	public void setUp() {
		modelMapper = spy(new ModelMapper());
//		modelMapper.getConfiguration().setFieldMatchingEnabled(true) ;
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
//		modelMapper.addMappings(new Store());
//		new ModelMapper();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllStore() {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		List<StoreDTO> storeDtos = StoreTestData.createStoresDTO2Records();
//		when(storeRepository.findAll()).thenReturn(StoreTestData.createStores2Records());
		Mockito.when(storeRepository.findAll()).thenReturn(StoreTestData.createStores2Records());
		StoresDTO storeFromService = storeService.getAllStore();
		assertNotNull(storeFromService);
		assertEquals(2, storeFromService.getStoreDtos().size());
		StoreDTO s = storeFromService.getStoreDtos().get(0);
		assertEquals(1l, s.getStoreId());
		assertEquals("Store 1", s.getStoreName());
		assertEquals(12, s.getStoreQuantity());

	}
}
