package com.smk.store.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.smk.store.StoreTestData;
import com.smk.store.dto.StoresDTO;
import com.smk.store.service.impl.StoreServiceImpl;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Mock
	private StoreServiceImpl storeService;

	@InjectMocks
	private StoreController storeControllerTest;

	private static final String STORE_ID = "/store";

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		System.out.println(context);
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc = MockMvcBuilders.standaloneSetup(storeControllerTest).build();
	}

	@Test
	public void testGetAllStore() throws Exception {

		StoresDTO store = new StoresDTO();
		store.setStoreDtos((StoreTestData.createStoresDTO2Records()));

		Mockito.when(storeService.getAllStore()).thenReturn(store);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(STORE_ID).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue())).andDo(print())
				.andExpect(jsonPath("$.storeDtos", hasSize(2)))
				.andExpect(jsonPath("$.storeDtos[0].storeName", is("Store 1")))
				.andExpect(jsonPath("$.storeDtos[0].storeQuantity", is(12)))
				.andExpect(jsonPath("$.storeDtos[1].storeName", is("Store 2")))
				.andExpect(jsonPath("$.storeDtos[1].storeQuantity", is(22))).andExpect(status().isOk());
	}

	@Test
	public void testGetAllStore_2() throws Exception {
		mockMvc.perform(get("/store").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

	}

//	@Test
//	public void greetingShouldReturnDefaultMessage() throws Exception {
////		StoresDTO s = new StoresDTO();
////		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/store", StoresDTO.class))
////				.contains(s);
//	}
}
