package com.mercadolibre.compatibilitiespoc.controller;

import com.mercadolibre.compatibilitiespoc.model.Car;
import com.mercadolibre.compatibilitiespoc.repository.CarRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/car")
public class CarController {

	private final CarRepository carRepository;

//	@Autowired
	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@GetMapping("/{brand}/{model}/{year}")
	public List<Car> getCarCompatibilities(@PathVariable String brand, @PathVariable String model, @PathVariable Integer year) {
		return carRepository.findByBrandAndModelAndYear(brand, model, year);
	}

	@GetMapping()
	public List<Car> getCars() {
		List<Car> response = new ArrayList<>();
		carRepository.findAll()
				.forEach(response::add);
		return response;
	}

	@GetMapping("/{brand}")
	public List<Car> getCars(@PathVariable String brand) {
		return carRepository.findByBrand(brand);
	}

	@GetMapping("/{brand}/{model}")
	public List<Car> getCars(@PathVariable String brand, @PathVariable String model) {
		return carRepository.findByBrandAndModel(brand, model);
	}
}
