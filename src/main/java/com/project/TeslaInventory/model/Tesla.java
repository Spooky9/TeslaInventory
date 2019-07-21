package com.project.TeslaInventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tesla")
public class Tesla {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String model;
	private String battery;
	private String color;
	private Integer wheelSize;
	private String interior;
	private Boolean autopilot;
	
	public Tesla() {}
	
	public Tesla(String model, String battery, String color, Integer wheelSize, String interior, Boolean autopilot) {
		this.model = model;
		this.battery = battery;
		this.color = color;
		this.wheelSize = wheelSize;
		this.interior = interior;
		this.autopilot = autopilot;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
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

	public String getInterior() {
		return interior;
	}

	public void setInterior(String interior) {
		this.interior = interior;
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
