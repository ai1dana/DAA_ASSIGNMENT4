package com.aitu;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import com.aitu.graph.topo.KahnTopologicalSort;
import com.aitu.graph.topo.TopologicalResult;

public class Main {

    public static void main(String[] args) throws Exception {
        String csvPath = "data/inputs/sample_graph.csv";

        DirectedGraph graph = CSVGraphIO.readGraph(csvPath, 9);
        System.out.println("=== GRAPH FROM CSV ===");
        System.out.println(graph);

        KahnTopologicalSort topoSort = new KahnTopologicalSort();
        try {
            TopologicalResult topoResult = topoSort.run(graph);
            System.out.println("=== Topological Sort (Kahn's Algorithm) ===");
            System.out.println(topoResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
