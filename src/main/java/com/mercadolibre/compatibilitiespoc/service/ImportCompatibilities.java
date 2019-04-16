package com.mercadolibre.compatibilitiespoc.service;

import com.mercadolibre.compatibilitiespoc.model.Car;
import com.mercadolibre.compatibilitiespoc.model.CarPiece;
import com.mercadolibre.compatibilitiespoc.model.ImportDTO;
import com.mercadolibre.compatibilitiespoc.model.Network;
import com.mercadolibre.compatibilitiespoc.repository.CarPieceRepository;
import com.mercadolibre.compatibilitiespoc.repository.CarRepository;
import com.mercadolibre.compatibilitiespoc.repository.GraphRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.RandomStringUtils;
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
	private GraphRepository graphRepository;

	@Autowired
	public ImportCompatibilities(CarPieceRepository carPieceRepository, CarRepository carRepository, GraphRepository graphRepository) {
		this.carPieceRepository = carPieceRepository;
		this.carRepository = carRepository;
		this.graphRepository = graphRepository;
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

		Network graph = new Network();
		graph.setId("compats");
		Network save = graphRepository.save(graph);
		log.info("graph saved: {}", save.toString());

		for (ImportDTO record : records) {// busca en la db o crea uno
			try {
				carPieceRepository.findByBrandAndMpn(record.getCarPartBrand(), record.getCarPartMPN());
			} catch (Exception e) {
				save.addVertex(new CarPiece(RandomStringUtils.random(6), record.getCarPartBrand(), record.getCarPartMPN()));
			}

			try {
				carRepository.findByBrandAndModelAndYearAndTrim(record.getCarBrand(), record.getCarModel(), record.getCarYear(), record.getCarTrim());
			} catch (Exception e) {
				save.addVertex(new Car(RandomStringUtils.random(6), record.getCarBrand(), record.getCarModel(), record.getCarYear(), record.getCarTrim()));
			}

			log.info("saving graph again: {}", save.toString());
			graphRepository.save(save);

		}
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
