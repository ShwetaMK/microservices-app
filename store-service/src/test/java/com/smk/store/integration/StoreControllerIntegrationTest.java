package com.smk.store.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.smk.store.StoreServiceApplication;
import com.smk.store.model.Store;
import com.smk.store.repository.StoreRepository;

@RunWith(SpringRunner.class)

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = StoreServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class StoreControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StoreRepository repository;

	private static final String STORE_URL = "/store";

//	@LocalServerPort
//	private int port;

	@Before
	public void setup() {
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

		createStore("Test Books1", 11);
		createStore("Test Books2", 22);

		mockMvc.perform(get(STORE_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.storeDtos", hasSize(2)))
				.andExpect(jsonPath("$.storeDtos[0].storeName", is("Test Books1")))
				.andExpect(jsonPath("$.storeDtos[0].storeQuantity", is(11)))
				.andExpect(jsonPath("$.storeDtos[1].storeName", is("Test Books2")))
				.andExpect(jsonPath("$.storeDtos[1].storeQuantity", is(22))).andExpect(status().isOk());
	}

	private void createStore(String storeName, Integer storeQuantity) {

		Store s = new Store();
		s.setStoreName(storeName);
		s.setStoreQuantity(storeQuantity);
		repository.save(s);

	}
}
