package org.viz.test.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DFSAlgorithm {
	private final Graph graph;

	private Set<String> visited = new HashSet<String>();

	public DFSAlgorithm(Graph graph, String source) {
		this.graph = graph;
		DFSViz.dfsViz.viz(this);
		this.run(source);
	}
	
	public Graph getGraph() {
		return this.graph;
	}

	public Set<String> getVisited() {
		return Collections.unmodifiableSet(this.visited);
	}

	private void run(String source) {
		if(this.visited.add(source)) {
			DFSViz.dfsViz.viz(this);
			for(String sink : this.graph.getOutgoingEdges(source)) {
				this.run(sink);
			}
		}
	}
}
