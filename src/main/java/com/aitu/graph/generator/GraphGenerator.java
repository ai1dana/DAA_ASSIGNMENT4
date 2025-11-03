package com.aitu.graph.generator;

import com.aitu.core.DirectedGraph;
import com.aitu.core.Edge;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GraphGenerator {

    private static final Random rand = new Random();

    public static DirectedGraph generateDAG(int n, int edgesCount) {
        DirectedGraph graph = new DirectedGraph(n);
        Set<String> addedEdges = new HashSet<>();

        for (int i = 0; i < edgesCount; i++) {
            int u = rand.nextInt(n);
            int v = rand.nextInt(n);

            if (u == v || u > v) {
                continue;
            }

            double weight = rand.nextDouble() * 10;

            if (!addedEdges.contains(u + "->" + v)) {
                graph.addEdge(u, v, weight);
                addedEdges.add(u + "->" + v);
            }
        }

        return graph;
    }

    public static void saveGraphToCSV(DirectedGraph graph, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            writer.write("u,v,w\n");
            for (int i = 0; i < graph.size(); i++) {
                for (Edge e : graph.edgesFrom(i)) {
                    writer.write(i + "," + e.getTo() + "," + e.getWeight() + "\n");
                }
            }
        }
    }

    public static void generateDatasets() throws IOException {
        for (int i = 6; i <= 10; i++) {
            DirectedGraph graph = generateDAG(i, i * 2);
            saveGraphToCSV(graph, "data/inputs/small_graph_" + i + ".csv");
        }

        for (int i = 10; i <= 20; i++) {
            DirectedGraph graph = generateDAG(i, i * 3);
            saveGraphToCSV(graph, "data/inputs/medium_graph_" + i + ".csv");
        }

        for (int i = 20; i <= 50; i++) {
            DirectedGraph graph = generateDAG(i, i * 5);
            saveGraphToCSV(graph, "data/inputs/large_graph_" + i + ".csv");
        }
    }

    public static void main(String[] args) throws IOException {

        generateDatasets();
        System.out.println("Graph generation is complete!");
    }
}
