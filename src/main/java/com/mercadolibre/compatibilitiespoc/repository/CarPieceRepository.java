package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.CarPiece;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPieceRepository extends GremlinRepository<CarPiece, String> {

	Optional<CarPiece> findByBrandAndMpn(String brand, String mpn);
}
