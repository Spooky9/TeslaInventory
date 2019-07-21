package com.project.TeslaInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.TeslaInventory.model.Tesla;
import com.project.TeslaInventory.service.TeslaServiceImpl;

@RestController
@RequestMapping("/api")
public class TeslaController {

	@Autowired
	private TeslaServiceImpl service;
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "index";
	}
	
	@PostMapping("/tesla")
	public String createTesla(Tesla tesla) {
		service.saveTesla(tesla);
		return "Tesla created successfully";
	}
	
	@PutMapping("/tesla/{id}")
	public String updateTesla(@PathVariable Long id, Tesla tesla) {
		service.updateTesla(id, tesla);
		return "Tesla updated successfully";
	}
	
	@GetMapping("/teslas")
	public List<Tesla> returnAllTeslas() {
		return service.getAll();
	}
	
	@GetMapping("/tesla/{id}")
	public Tesla returnTeslaById(@PathVariable Long id) {
		return service.getTeslaById(id);
	}
	
	@GetMapping("/tesla/color/{color}")
	public List<Tesla> returnTeslaByColor(@PathVariable String color){
		return service.getTeslaByColor(color);
	}
	
	@GetMapping("/tesla/model/{model}")
	public List<Tesla> returnTeslaByModel(@PathVariable String model){
		return service.getTeslaByModel(model);
	}
	
	@GetMapping("/tesla/battery/{battery}")
	public List<Tesla> returnTeslaByBattery(@PathVariable String battery){
		return service.getTeslaByBattery(battery);
	}
	
	@GetMapping("/tesla/wheel/{wheelSize}")
	public List<Tesla> returnTeslaByWheelSize(@PathVariable int wheelSize){
		return service.getTeslaByWheelSize(wheelSize);
	}
	
	@GetMapping("/tesla/interior/{interior}")
	public List<Tesla> returnTeslaByInterior(@PathVariable String interior){
		return service.getTeslaByInterior(interior);
	}
	
	@GetMapping("/tesla/autopilot/{hasAutopilot}")
	public List<Tesla> returnTeslaByAutopilot(@PathVariable boolean hasAutopilot){
		return service.getTeslaByAutopilot(hasAutopilot);
	}
}
