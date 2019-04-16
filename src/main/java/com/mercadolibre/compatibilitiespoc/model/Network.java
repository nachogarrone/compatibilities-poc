package com.mercadolibre.compatibilitiespoc.model;

import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.Graph;
import com.microsoft.spring.data.gremlin.annotation.VertexSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;

@Graph
public class Network {

	@Id
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

	@Override
	public String toString() {
		return "Network{" + "id='" + id + '\'' + ", edges=" + edges + ", vertexes=" + vertexes + '}';
	}
}