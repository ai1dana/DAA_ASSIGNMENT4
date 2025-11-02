package com.aitu;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import com.aitu.algorithms.scc.TarjanSCC;
import com.aitu.algorithms.scc.SCCResult;
import com.aitu.algorithms.scc.CondensationGraph;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String csvPath = "data/inputs/sample_graph.csv";

        DirectedGraph graph = CSVGraphIO.readGraph(csvPath, 8);
        System.out.println("=== GRAPH FROM CSV ===");
        System.out.println(graph);

        TarjanSCC tarjan = new TarjanSCC();
        SCCResult sccResult = tarjan.run(graph);
        System.out.println("=== SCC (Tarjan) ===");
        System.out.println("Found " + sccResult.count() + " strongly connected components.");
        for (List<Integer> component : sccResult.getComponents()) {
            System.out.println(component);
        }

        DirectedGraph dag = CondensationGraph.build(graph, sccResult);
        System.out.println("=== Condensation Graph (DAG) ===");
        System.out.println(dag);

        System.out.println("=== Performance Metrics ===");
        System.out.println("Time elapsed: " + tracker.elapsedNanos() + " ns");
        System.out.println("DFS visits: " + tracker.get("dfs_visit"));
        System.out.println("DFS edges: " + tracker.get("dfs_edge"));
    }
}
