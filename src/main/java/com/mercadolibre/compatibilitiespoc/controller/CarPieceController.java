package com.mercadolibre.compatibilitiespoc.controller;

import com.mercadolibre.compatibilitiespoc.model.CarPiece;
import com.mercadolibre.compatibilitiespoc.repository.CarPieceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piece")
public class CarPieceController {

	private CarPieceRepository carPieceRepository;

	@Autowired
	public CarPieceController(CarPieceRepository carPieceRepository) {
		this.carPieceRepository = carPieceRepository;
	}

	@GetMapping()
	public List<CarPiece> getCarPieces() {
		List<CarPiece> response = new ArrayList<>();
		carPieceRepository.findAll()
				.forEach(response::add);
		return response;
	}
}
