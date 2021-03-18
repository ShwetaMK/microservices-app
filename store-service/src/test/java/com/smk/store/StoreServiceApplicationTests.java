package com.smk.store;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.smk.store.controller.StoreController;

@SpringBootTest
//@Configuration
@RunWith(MockitoJUnitRunner.class)
class StoreServiceApplicationTests {

	@Autowired
	StoreController storeController;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoads_1() throws Exception {
		assertThat(storeController).isNotNull();
	}
}
