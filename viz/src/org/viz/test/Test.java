package org.viz.test;

import org.viz.test.graph.DFSAlgorithm;
import org.viz.test.graph.Graph;

public class Test {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge("0", "1");
		g.addEdge("1", "2");
		g.addEdge("2", "3");
		g.addEdge("3", "4");
		g.addEdge("4", "0");

		new DFSAlgorithm(g, "0");
	}
}
