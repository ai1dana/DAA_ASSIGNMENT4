package com.aitu.graph.dagsp;

import com.aitu.core.DirectedGraph;
import com.aitu.core.Edge;
import com.aitu.graph.topo.KahnTopologicalSort;
import com.aitu.graph.topo.TopologicalResult;



import java.util.List;

public class DAGShortestPath {

    public PathResult run(DirectedGraph graph, int start) {
        KahnTopologicalSort topoSort = new KahnTopologicalSort();
        TopologicalResult topoResult = topoSort.run(graph);

        if (topoResult == null) {
            System.out.println("Error: The graph contains a cycle. Shortcuts are impossible.");
            return null;
        }

        List<Integer> order = topoResult.getOrder();
        int n = graph.size();
        PathResult result = new PathResult(n);
        result.dist[start] = 0.0;

        for (int u : order) {
            if (result.dist[u] != Double.POSITIVE_INFINITY) {
                for (Edge e : graph.edgesFrom(u)) {
                    int v = e.getTo();
                    double weight = e.getWeight();
                    if (result.dist[v] > result.dist[u] + weight) {
                        result.dist[v] = result.dist[u] + weight;
                        result.prev[v] = u;
                    }
                }
            }
        }

        return result;
    }
}
