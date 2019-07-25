package com.project.TeslaInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.TeslaInventory.model.Tesla;
import com.project.TeslaInventory.service.TeslaServiceImpl;

@Controller
@RequestMapping("/api")
public class TeslaController {

	@Autowired
	private TeslaServiceImpl service;
	
	@GetMapping("/")
	public String home(Model model, Tesla tesla) {
		List<Tesla> teslaList = service.getAll();
		model.addAttribute("allTeslas", teslaList);
		return "index";
	}
	
	@PostMapping("/tesla")
	@ResponseBody
	public String createTesla(Tesla tesla) {
		service.saveTesla(tesla);
		return "Tesla created successfully";
	}
	
	@PutMapping("/tesla/{id}")
	@ResponseBody
	public String updateTesla(@PathVariable Long id, Tesla tesla) {
		service.updateTesla(id, tesla);
		return "Tesla updated successfully";
	}
	
	@GetMapping("/teslas")
	@ResponseBody
	public List<Tesla> returnAllTeslas() {
		return service.getAll();
	}
	
	@GetMapping("/tesla/{id}")
	@ResponseBody
	public Tesla returnTeslaById(@PathVariable Long id) {
		return service.getTeslaById(id);
	}
	
	@GetMapping("/tesla/color/{color}")
	@ResponseBody
	public List<Tesla> returnTeslaByColor(@PathVariable String color){
		return service.getTeslaByColor(color);
	}
	
	@GetMapping("/tesla/model/{model}")
	@ResponseBody
	public List<Tesla> returnTeslaByModel(@PathVariable String model){
		return service.getTeslaByModel(model);
	}
	
	@GetMapping("/tesla/battery/{batteryRange}")
	public List<Tesla> returnTeslaByBatteryRange(@PathVariable String batteryRange){
		return service.getTeslaByBatteryRange(batteryRange);
	}
	
	@GetMapping("/tesla/wheel/{wheelSize}")
	@ResponseBody
	public List<Tesla> returnTeslaByWheelSize(@PathVariable int wheelSize){
		return service.getTeslaByWheelSize(wheelSize);
	}
	
	@GetMapping("/tesla/interior/{interiorColor}")
	@ResponseBody
	public List<Tesla> returnTeslaByInteriorColor(@PathVariable String interiorColor){
		return service.getTeslaByInteriorColor(interiorColor);
	}
	
	@GetMapping("/tesla/autopilot/{hasAutopilot}")
	@ResponseBody
	public List<Tesla> returnTeslaByAutopilot(@PathVariable boolean hasAutopilot){
		return service.getTeslaByAutopilot(hasAutopilot);
	}
	
	@DeleteMapping("/tesla/{id}")
	@ResponseBody
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "Tesla Deleted Successfully";
	}
	
	@DeleteMapping("/teslas")
	@ResponseBody
	public String deleteAll() {
		service.deleteAll();
		return "All Teslas Deleted Successfully";
	}
}
