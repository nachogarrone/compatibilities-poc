package com.mercadolibre.compatibilitiespoc.model;

import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.Graph;
import com.microsoft.spring.data.gremlin.annotation.VertexSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;

@Graph
public class Network {

	@Id
	@GeneratedValue
	private String id;
	@EdgeSet
	private List<Object> edges;
	@VertexSet
	private List<Object> vertexes;

	public Network() {
		this.edges = new ArrayList<>();
		this.vertexes = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addEdge(Object edge) {
		this.edges.add(edge);
	}

	public void addVertex(Object vertex) {
		this.vertexes.add(vertex);
	}

	public List<Object> getEdges() {
		return edges;
	}

	public List<Object> getVertexes() {
		return vertexes;
	}
}