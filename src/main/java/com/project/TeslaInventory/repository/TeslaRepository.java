package com.project.TeslaInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TeslaInventory.model.Tesla;

@Repository
public interface TeslaRepository extends JpaRepository<Tesla, Long>{

	Tesla findTeslaById(Long id);
	List<Tesla> findAllByColor(String color);
	List<Tesla> findAllByModel(String model);
	List<Tesla> findAllByBattery(String battery);
	List<Tesla> findAllByWheelSize(Integer wheelSize);
	List<Tesla> findAllByInterior(String interior);
	List<Tesla> findAllByAutopilot(Boolean autopilot);
}
