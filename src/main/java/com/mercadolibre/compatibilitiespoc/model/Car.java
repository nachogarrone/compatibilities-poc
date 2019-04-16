package com.mercadolibre.compatibilitiespoc.model;

import com.microsoft.spring.data.gremlin.annotation.Vertex;
import org.springframework.data.annotation.Id;

@Vertex
public class Car {

	@Id
	private Long id;
	private String brand;
	private String model;
	private int year;
	private String trim;

	public Car(Long id, String brand, String model, int year, String trim) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.trim = trim;
	}

	public Car() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	@Override
	public String toString() {
		return "Car{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", year=" + year + ", trim='" + trim + '\'' + '}';
	}
}
