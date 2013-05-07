package org.viz.test.graph;

import java.util.Set;

import org.viz.core.DotObject;
import org.viz.core.JSONObject;
import org.viz.core.JSONObject.JSONBoolean;
import org.viz.core.JSONObject.JSONList;
import org.viz.core.JSONObject.JSONString;
import org.viz.core.Viz;

public class DFSViz extends Viz<DFSAlgorithm> {
	public static final DFSViz dfsViz = new DFSViz("dfs");
	
	public DFSViz(String filename) {
		super(filename);
	}
	
	@Override
	public JSONObject vizJSON(DFSAlgorithm d) {
		JSONList nodes = new JSONList();

		Set<String> visited = d.getVisited();
		Graph g = d.getGraph();
		for(String name : g.getNodes()) {
			JSONList neighbors = new JSONList();
			for(String neighbor : g.getOutgoingEdges(name)) {
				neighbors.add(new JSONString(neighbor));
			}

			JSONObject node = new JSONObject();
			node.put("name", new JSONString(name));
			node.put("visited", new JSONBoolean(visited.contains(name)));
			node.put("neighbors", neighbors);
			nodes.add(node);
		}

		JSONObject result = new JSONObject();
		result.put("nodes", nodes);
		return result;
	}

	@Override
	public DotObject vizDot(DFSAlgorithm d) {
		DotObject dot = new DotObject("viz");
		Set<String> visited = d.getVisited();
		Graph g = d.getGraph();
		for(String name : g.getNodes()) {
			for(String neighbor : g.getOutgoingEdges(name)) {
				dot.addEdge(name, neighbor);
			}
			if(visited.contains(name)) {
				dot.setNodeProperty(name, "color", "Red");
			}
		}
		return dot;
	}
}
