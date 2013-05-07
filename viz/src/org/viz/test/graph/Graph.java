package org.viz.test.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	private static class Node {
		private Set<String> outgoingEdges = new HashSet<String>();
		private Set<String> incomingEdges = new HashSet<String>();
	}

	private Map<String,Node> nodes = new HashMap<String,Node>();

	private Node getNode(String name) {
		Node node = this.nodes.get(name);
		if(node == null) {
			node = new Node();
			this.nodes.put(name, node);
		}
		return node;
	}

	public void addEdge(String source, String sink) {
		this.getNode(source).outgoingEdges.add(sink);
		this.getNode(sink).incomingEdges.add(source);
	}

	public Set<String> getNodes() {
		return this.nodes.keySet();
	}

	public Set<String> getOutgoingEdges(String source) {
		return Collections.unmodifiableSet(this.getNode(source).outgoingEdges);
	}

	public Set<String> getIncomingEdges(String sink) {
		return Collections.unmodifiableSet(this.getNode(sink).incomingEdges);
	}
}
