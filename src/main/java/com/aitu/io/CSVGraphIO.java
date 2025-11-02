package com.aitu.io;

import com.aitu.core.DirectedGraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class CSVGraphIO {
    private CSVGraphIO() {}

    public static DirectedGraph readGraph(String path, int nodeCount) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        DirectedGraph graph = new DirectedGraph(nodeCount);
        for (String line : lines) {
            String t = line.trim();
            if (t.isEmpty() || t.startsWith("u")) continue;
            String[] parts = t.split(",");
            int u = Integer.parseInt(parts[0].trim());
            int v = Integer.parseInt(parts[1].trim());
            double w = Double.parseDouble(parts[2].trim());
            graph.addEdge(u, v, w);
        }
        return graph;
    }
}

