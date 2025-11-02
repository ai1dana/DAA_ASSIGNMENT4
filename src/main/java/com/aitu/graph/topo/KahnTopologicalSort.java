package com.aitu.graph.topo;

import com.aitu.core.DirectedGraph;
import com.aitu.core.Edge;

import java.util.*;


public class KahnTopologicalSort {


    public TopologicalResult run(DirectedGraph graph) {
        int n = graph.size();
        int[] inDegree = new int[n];

        for (int v = 0; v < n; v++) {
            for (Edge e : graph.edgesFrom(v)) {
                inDegree[e.getTo()]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < n; v++) {
            if (inDegree[v] == 0) {
                queue.offer(v);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            topologicalOrder.add(v);

            for (Edge e : graph.edgesFrom(v)) {
                inDegree[e.getTo()]--;
                if (inDegree[e.getTo()] == 0) {
                    queue.offer(e.getTo());
                }
            }
        }

        if (topologicalOrder.size() != n) {
            throw new IllegalArgumentException("The graph contains a cycle, topological sorting is not possible");
        }

        return new TopologicalResult(topologicalOrder);
    }
}
