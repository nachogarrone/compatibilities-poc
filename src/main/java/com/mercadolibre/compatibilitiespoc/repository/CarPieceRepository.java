package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.CarPiece;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CarPieceRepository extends CrudRepository<CarPiece, Long> {

	Optional<CarPiece> findByBrandAndMpn(String brand, String mpn);
}
