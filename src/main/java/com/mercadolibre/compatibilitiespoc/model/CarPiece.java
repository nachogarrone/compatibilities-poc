package com.mercadolibre.compatibilitiespoc.model;

import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.Vertex;

@Vertex
public class CarPiece {

	@GeneratedValue
	private Long id;

	private String brand;
	private String mpn;

	public CarPiece() {
	}

	public CarPiece(String brand, String mpn) {
		this.brand = brand;
		this.mpn = mpn;
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

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	@Override
	public String toString() {
		return "CarPiece{" + "id=" + id + ", brand='" + brand + '\'' + ", mpn='" + mpn + '\'' + '}';
	}
}
