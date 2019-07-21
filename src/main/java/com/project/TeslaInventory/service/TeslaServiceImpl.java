package com.project.TeslaInventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TeslaInventory.model.Tesla;
import com.project.TeslaInventory.repository.TeslaRepository;

@Service
public class TeslaServiceImpl implements TeslaServiceInt{

	@Autowired
	private TeslaRepository repo;

	@Override
	public List<Tesla> getAll() {
		return repo.findAll();
	}
	
	@Override
	public Tesla getTeslaById(Long id) {
		return repo.findTeslaById(id);
	}

	@Override
	public List<Tesla> getTeslaByColor(String color) {
		return repo.findAllByColor(color);
	}

	@Override
	public List<Tesla> getTeslaByModel(String model) {
		return repo.findAllByModel(model);
	}

	@Override
	public List<Tesla> getTeslaByBattery(String battery) {
		return repo.findAllByBattery(battery);
	}

	@Override
	public List<Tesla> getTeslaByWheelSize(Integer wheelSize) {
		return repo.findAllByWheelSize(wheelSize);
	}

	@Override
	public List<Tesla> getTeslaByInterior(String interior) {
		return repo.findAllByInterior(interior);
	}

	@Override
	public List<Tesla> getTeslaByAutopilot(Boolean hasAutopilot) {
		return repo.findAllByAutopilot(hasAutopilot);
	}

	@Override
	public void saveTesla(Tesla tesla) {
		repo.save(tesla);
	}

	@Override
	public void updateTesla(Long id, Tesla updateTesla) {
		Tesla teslaToReplace = repo.findTeslaById(id);
		String color = updateTesla.getColor();
		String model = updateTesla.getModel();
		String battery = updateTesla.getBattery();
		Integer wheel = updateTesla.getWheelSize();
		String interior = updateTesla.getInterior();
		Boolean autopilot = updateTesla.getAutopilot();
		
		if(color != null) teslaToReplace.setColor(color);
		if(model != null) teslaToReplace.setModel(model);
		if(battery != null) teslaToReplace.setBattery(battery);
		if(wheel != null) teslaToReplace.setWheelSize(wheel);
		if(interior != null) teslaToReplace.setInterior(interior);
		if(autopilot != null) teslaToReplace.setAutopilot(autopilot);
		
		repo.save(teslaToReplace);
	}
}
