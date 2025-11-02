package com.aitu;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import com.aitu.io.JSONGraphIO;

public class Main {
    public static void main(String[] args) throws Exception {
        String csvPath = "data/inputs/sample_graph.csv";
        String jsonPath = "data/inputs/sample_graph.json";

        DirectedGraph csvGraph = CSVGraphIO.readGraph(csvPath, 8);
        System.out.println("=== GRAPH FROM CSV ===");
        System.out.println(csvGraph);

        DirectedGraph jsonGraph = JSONGraphIO.readGraph(jsonPath);
        System.out.println("=== GRAPH FROM JSON ===");
        System.out.println(jsonGraph);
    }
}
