package com.project.TeslaInventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Tesla {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Model Required")
	@Pattern(regexp="^(Model S|Model 3|Model X)")
	private String model;
	
	@NotBlank(message="Battery Required")
	@Pattern(regexp="^(Standard|Long|Performance)")
	private String batteryRange;
	
	@NotBlank(message="Color Required")
	@Pattern(regexp="^(White|Black|Silver|Blue|Red)")
	private String color;
	
	private Integer wheelSize;
	
	@NotBlank(message="Interior Required")
	@Pattern(regexp="^(White|Black|Cream)")
	private String interiorColor;
	private Boolean autopilot;
	
	public Tesla() {}
	
	public Tesla(String model, String batteryRange, String color, Integer wheelSize, String interiorColor, Boolean autopilot) {
		this.model = model;
		this.batteryRange = batteryRange;
		this.color = color;
		this.wheelSize = wheelSize;
		this.interiorColor = interiorColor;
		this.autopilot = autopilot;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBatteryRange() {
		return batteryRange;
	}

	public void setBatteryRange(String batteryRange) {
		this.batteryRange = batteryRange;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(Integer wheelSize) {
		this.wheelSize = wheelSize;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public Boolean getAutopilot() {
		return autopilot;
	}

	public void setAutopilot(Boolean autopilot) {
		this.autopilot = autopilot;
	}

	public Long getId() {
		return id;
	}
}