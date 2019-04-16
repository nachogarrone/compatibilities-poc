package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.CarPiece;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPieceRepository extends CrudRepository<CarPiece, String> {

	Optional<CarPiece> findByBrandAndMpn(String brand, String mpn);
}
