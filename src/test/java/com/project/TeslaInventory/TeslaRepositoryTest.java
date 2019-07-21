package com.project.TeslaInventory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.TeslaInventory.model.Tesla;
import com.project.TeslaInventory.repository.TeslaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeslaRepositoryTest {
	
	private Tesla carOne;
	private Tesla carTwo;
	private Tesla carThree;

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TeslaRepository repo;
	
	@Before
	public void setUp() {
		
		carOne = new Tesla("S", "Long", "Red", 20, "White", true);
		carTwo = new Tesla("3", "Standard", "Red", 19, "Black", false);
		carThree = new Tesla("3", "Standard", "Black", 19, "Black", false);
		entityManager.persistAndFlush(carOne);
		entityManager.persistAndFlush(carTwo);
		entityManager.persistAndFlush(carThree);
	}
	
	@Test
	public void findById_shouldReturnCorrectTesla() {
		Tesla found = repo.findTeslaById(carOne.getId());
		
		assertThat(found).isEqualTo(carOne);
	}

	@Test
	public void findAllByColor_shouldReturnCorrectTeslaList() {
		List<Tesla> cars = Arrays.asList(carOne, carTwo);
		List<Tesla> found = repo.findAllByColor(carOne.getColor());
		
		assertEquals(cars, found);
	}
	
	@Test
	public void findAllByModel_shouldReturnCorrectTeslaList() {
		List<Tesla> cars = Arrays.asList(carTwo, carThree);
		List<Tesla> found = repo.findAllByModel(carTwo.getModel());
		
		assertEquals(cars, found);
	}
	
	@Test
	public void findAllByBattery_shouldReturnCorrectTeslaList() {
		List<Tesla> cars = Arrays.asList(carTwo, carThree);
		List<Tesla> found = repo.findAllByBattery(carTwo.getBattery());
		
		assertEquals(cars, found);
	}
	
	
	@Test
	public void findAllByWheelSize_shouldReturnCorrectTeslaList() {
		List<Tesla> cars = Arrays.asList(carTwo, carThree);
		List<Tesla> found = repo.findAllByWheelSize(carTwo.getWheelSize());
		
		assertEquals(cars, found);
	}
	
	@Test
	public void findAllByInterior_shouldReturnCorrectTeslaList() {
		List<Tesla> cars = Arrays.asList(carTwo, carThree);
		List<Tesla> found = repo.findAllByInterior(carTwo.getInterior());
		
		assertEquals(cars, found);
	}
	
	@Test
	public void findAllByAutopilot_shouldReturnCorrectTeslaList() {
		List<Tesla> cars = Arrays.asList(carTwo, carThree);
		List<Tesla> found = repo.findAllByAutopilot(carTwo.getAutopilot());
		
		assertEquals(cars, found);
	}
}
