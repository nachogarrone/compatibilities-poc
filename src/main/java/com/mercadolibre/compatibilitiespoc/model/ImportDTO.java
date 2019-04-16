package com.mercadolibre.compatibilitiespoc.model;

public class ImportDTO {
	private String carPartBrand;
	private String carPartMPN;

	private String carBrand;
	private String carModel;
	private Integer carYear;
	private String carTrim;

	public String getCarPartBrand() {
		return carPartBrand;
	}

	public void setCarPartBrand(String carPartBrand) {
		this.carPartBrand = carPartBrand;
	}

	public String getCarPartMPN() {
		return carPartMPN;
	}

	public void setCarPartMPN(String carPartMPN) {
		this.carPartMPN = carPartMPN;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getCarYear() {
		return carYear;
	}

	public void setCarYear(Integer carYear) {
		this.carYear = carYear;
	}

	public String getCarTrim() {
		return carTrim;
	}

	public void setCarTrim(String carTrim) {
		this.carTrim = carTrim;
	}
}
