package com.project.TeslaInventory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.TeslaInventory.model.Tesla;
import com.project.TeslaInventory.repository.TeslaRepository;
import com.project.TeslaInventory.service.TeslaServiceImpl;
import com.project.TeslaInventory.service.TeslaServiceInt;

@RunWith(SpringRunner.class)

public class TeslaServiceTest {
	
	private Tesla carOne;
	
	@Autowired
	private TeslaServiceImpl service;
	
	@MockBean
	private TeslaRepository repo;

	@Configuration
	public static class ServiceConfiguration{
		@Bean
		public TeslaServiceInt config() {
			return new TeslaServiceImpl();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		carOne = new Tesla("3", "Standard", "Blue", 19, "Black", false);
	}

	@Test
	public void givenId_returnCorrectTesla() {
		Mockito.when(repo.findTeslaById(carOne.getId())).thenReturn(carOne);
		Tesla found = service.getTeslaById(carOne.getId());
		
		assertEquals(carOne, found);
	}

}
