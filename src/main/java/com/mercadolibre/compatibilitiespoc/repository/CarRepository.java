package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {

	Optional<Car> findByBrandAndModelAndYearAndTrim(String brand, String model, int year, String trim);

	Optional<List<Car>> findByBrand(String brand);

	Optional<List<Car>> findByBrandAndModel(String brand, String model);

	Optional<List<Car>> findByBrandAndModelAndYear(String brand, String model, int year);

}
