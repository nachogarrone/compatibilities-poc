package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.Car;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends GremlinRepository<Car, String> {

	Optional<Car> findByBrandAndModelAndYearAndTrim(String brand, String model, int year, String trim);

	Optional<List<Car>> findByBrand(String brand);

	Optional<List<Car>> findByBrandAndModel(String brand, String model);

	Optional<List<Car>> findByBrandAndModelAndYear(String brand, String model, int year);

}
