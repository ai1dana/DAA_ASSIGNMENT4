package com.aitu;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
feature/scc
import com.aitu.algorithms.scc.TarjanSCC;
import com.aitu.algorithms.scc.SCCResult;
import com.aitu.algorithms.scc.CondensationGraph;

import java.util.List;
=======
import com.aitu.io.JSONGraphIO;
 master

public class Main {
    public static void main(String[] args) throws Exception {
        String csvPath = "data/inputs/sample_graph.csv";
feature/scc
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
=======
        String jsonPath = "data/inputs/sample_graph.json";

        DirectedGraph csvGraph = CSVGraphIO.readGraph(csvPath, 8);
        System.out.println("=== GRAPH FROM CSV ===");
        System.out.println(csvGraph);

        DirectedGraph jsonGraph = JSONGraphIO.readGraph(jsonPath);
        System.out.println("=== GRAPH FROM JSON ===");
        System.out.println(jsonGraph);
 master
    }
}
