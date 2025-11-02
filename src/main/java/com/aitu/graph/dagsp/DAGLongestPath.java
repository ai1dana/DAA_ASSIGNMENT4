package com.aitu.graph.dagsp;

import com.aitu.core.DirectedGraph;
import com.aitu.core.Edge;
import com.aitu.graph.topo.KahnTopologicalSort;
import com.aitu.graph.topo.TopologicalResult;

import java.util.Arrays;

public class DAGLongestPath {


    public PathResult run(DirectedGraph graph, int source) {
        int n = graph.size();
        PathResult result = new PathResult();
        result.dist = new double[n];
        result.parent = new int[n];
        Arrays.fill(result.dist, Double.NEGATIVE_INFINITY);
        Arrays.fill(result.parent, -1);
        result.dist[source] = 0;

        TopologicalResult topoResult = new KahnTopologicalSort().run(graph);
        int[] topoOrder = topoResult.getOrder().stream().mapToInt(Integer::intValue).toArray();

        for (int v : topoOrder) {
            if (result.dist[v] == Double.NEGATIVE_INFINITY) continue;
            for (Edge e : graph.edgesFrom(v)) {
                if (result.dist[e.getTo()] < result.dist[v] + e.getWeight()) {
                    result.dist[e.getTo()] = result.dist[v] + e.getWeight();
                    result.parent[e.getTo()] = v;
                }
            }
        }

        return result;
    }
}
