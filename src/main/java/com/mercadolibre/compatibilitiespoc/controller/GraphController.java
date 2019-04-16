package com.mercadolibre.compatibilitiespoc.controller;

import com.mercadolibre.compatibilitiespoc.model.Network;
import com.mercadolibre.compatibilitiespoc.repository.GraphRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graph")
public class GraphController {

	private final GraphRepository graphRepository;

	@Autowired
	public GraphController(GraphRepository graphRepository) {
		this.graphRepository = graphRepository;
	}

	@GetMapping("/{name}")
	public Network getGraph(@PathVariable String name) {
		return graphRepository.findById(name)
				.orElse(null);
	}

	@DeleteMapping
	public void delete() {
		graphRepository.deleteAll();
	}

	@PutMapping("{name}")
	public Network create(@PathVariable String name) {
		Network network = new Network();
		network.setId(name);
		return graphRepository.save(network);
	}

	@GetMapping()
	public List<Network> getGraphs() {
		List<Network> response = new ArrayList<>();
		graphRepository.findAll()
				.forEach(response::add);
		return response;
	}
}
