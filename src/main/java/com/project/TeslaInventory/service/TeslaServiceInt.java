package com.project.TeslaInventory.service;

import java.util.List;

import com.project.TeslaInventory.model.Tesla;

public interface TeslaServiceInt {

	public List<Tesla> getAll();
	public Tesla getTeslaById(Long id);
	public List<Tesla> getTeslaByColor(String color);
	public List<Tesla> getTeslaByModel(String model);
	public List<Tesla> getTeslaByBattery(String battery);
	public List<Tesla> getTeslaByWheelSize(Integer wheelSize);
	public List<Tesla> getTeslaByInterior(String interior);
	public List<Tesla> getTeslaByAutopilot(Boolean hasAutopilot);
	public void saveTesla(Tesla tesla);
	public void updateTesla(Long id, Tesla tesla);
	public void deleteById(Long id);
	public void deleteAll();
}
