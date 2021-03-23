package com.smk.inventory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smk.inventory.controller.InventoryController;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceApplicationTests {
	@Autowired
	InventoryController inventoryController;

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoads_1() throws Exception {
		assertThat(inventoryController).isNotNull();
	}

}
