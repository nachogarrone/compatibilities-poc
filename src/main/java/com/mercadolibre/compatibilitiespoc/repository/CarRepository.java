package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.Car;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends GremlinRepository<Car, String> {

	Car findByBrandAndModelAndYearAndTrim(String brand, String model, int year, String trim);

	List<Car> findByBrand(String brand);

	List<Car> findByBrandAndModel(String brand, String model);

	List<Car> findByBrandAndModelAndYear(String brand, String model, int year);

}
