package com.aitu.graph.scc;

import com.aitu.core.DirectedGraph;
import com.aitu.core.Edge;

import java.util.*;

public class CondensationGraph {
    private CondensationGraph() {}

    public static DirectedGraph build(DirectedGraph g, SCCResult scc) {
        int n = g.size();
        int componentCount = scc.count();
        int[] componentIds = new int[n];
        for (int i = 0; i < componentCount; i++) {
            for (int vertex : scc.getComponents().get(i)) {
                componentIds[vertex] = i;
            }
        }

        DirectedGraph dag = new DirectedGraph(componentCount);
        Set<Long> usedEdges = new HashSet<>();

        for (int v = 0; v < n; v++) {
            for (Edge e : g.edgesFrom(v)) {
                int u = componentIds[e.getFrom()];
                int v2 = componentIds[e.getTo()];

                if (u != v2) {
                    long edgeKey = ((long) u << 32) | v2;
                    if (!usedEdges.contains(edgeKey)) {
                        dag.addEdge(u, v2, e.getWeight());
                        usedEdges.add(edgeKey);
                    }
                }
            }
        }

        return dag;
    }
}
