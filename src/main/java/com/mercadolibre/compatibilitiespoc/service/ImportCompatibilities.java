package com.mercadolibre.compatibilitiespoc.service;

import com.mercadolibre.compatibilitiespoc.model.Car;
import com.mercadolibre.compatibilitiespoc.model.CarPiece;
import com.mercadolibre.compatibilitiespoc.model.ImportDTO;
import com.mercadolibre.compatibilitiespoc.repository.CarPieceRepository;
import com.mercadolibre.compatibilitiespoc.repository.CarRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportCompatibilities {
	private final static Logger log = LoggerFactory.getLogger(ImportCompatibilities.class);
	private static final String COMMA_DELIMITER = ",";

	private CarPieceRepository carPieceRepository;
	private CarRepository carRepository;

	@Autowired
	public ImportCompatibilities(CarPieceRepository carPieceRepository, CarRepository carRepository) {
		this.carPieceRepository = carPieceRepository;
		this.carRepository = carRepository;
	}

	private ImportDTO getRecordFromLine(String line) {
		ImportDTO importDTO = new ImportDTO();

		String[] values = line.split(COMMA_DELIMITER);
		importDTO.setCarPartBrand(values[ 0 ]);
		importDTO.setCarPartMPN(values[ 1 ]);
		importDTO.setCarBrand(values[ 2 ]);
		importDTO.setCarModel(values[ 3 ]);
		importDTO.setCarYear(Integer.valueOf(values[ 4 ]));
		importDTO.setCarTrim(values[ 5 ]);

		return importDTO;
	}

	@PostConstruct
	public void importCompats() {
		List<ImportDTO> records = new ArrayList<>();
		log.info("[IMPORT] Staring import...");
		ClassLoader classLoader = getClass().getClassLoader();
		try (Scanner scanner = new Scanner(classLoader.getResourceAsStream("autopartes.csv"))) {
			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				log.info("[IMPORT] Processing {}", nextLine);
				records.add(getRecordFromLine(nextLine));
			}
		}
		log.info("[IMPORT] Importing {} compatibilities.", records.size());

		records.forEach(record -> {

			// busca en la db o crea uno
			CarPiece piece;
			try {
				piece = carPieceRepository.findByBrandAndMpn(record.getCarPartBrand(), record.getCarPartMPN());
			} catch (Exception e) {
				piece = carPieceRepository.save(new CarPiece(record.getCarPartBrand(), record.getCarPartMPN()));
			}

			Car car;
			try {
				car = carRepository.findByBrandAndModelAndYearAndTrim(record.getCarBrand(), record.getCarModel(), record.getCarYear(), record.getCarTrim());
			} catch (Exception e) {
				car = new Car(record.getCarBrand(), record.getCarModel(), record.getCarYear(), record.getCarTrim());
			}

			carRepository.save(car);
		});
		log.info("[IMPORT] Finished import successfully!");
		log.info("[IMPORT] -----------------------------");
		log.info("[IMPORT] -----------------------------");

		carRepository.findAll()
				.forEach(c -> log.info(c.toString()));
		log.info("[IMPORT] -----------------------------");
		carPieceRepository.findAll()
				.forEach(c -> log.info(c.toString()));

		log.info("[IMPORT] -----------------------------");
		log.info("[IMPORT] -----------------------------");
	}
}
