package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	private final Map<N, Set<N>> adjacencyMap;
	
	public GraphImpl() {
		this(new HashMap<>());
	}
	
	public GraphImpl(Map<N, Set<N>> adjacencyMap) {
		this.adjacencyMap = adjacencyMap;
	}

	@Override
	public void addNode(final N node) {
		if (node != null) {
			this.adjacencyMap.put(node, new HashSet<>());
		}
	}

	@Override
	public void addEdge(N source, N target) {
		if (source != null && target != null && this.adjacencyMap.containsKey(source)) {
			this.adjacencyMap.get(source).add(target);
		}
	}

	@Override
	public Set<N> nodeSet() {
		return Set.copyOf(this.adjacencyMap.keySet());
	}

	@Override
	public Set<N> linkedNodes(N node) {
		return Set.copyOf(this.adjacencyMap.get(node));
	}

	@Override
	public List<N> getPath(N source, N target) {
		return null;
	}

}
