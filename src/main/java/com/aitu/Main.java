package com.aitu;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import com.aitu.graph.topo.KahnTopologicalSort;
import com.aitu.graph.topo.TopologicalResult;
import com.aitu.graph.scc.TarjanSCC;
import com.aitu.graph.scc.SCCResult;
import com.aitu.graph.dagsp.DAGShortestPath;
import com.aitu.graph.dagsp.DAGLongestPath;
import com.aitu.graph.dagsp.PathResult;
import com.aitu.metrics.PerformanceTracker;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String csvPath = "data/inputs/sample_graph.csv";

        DirectedGraph graph = CSVGraphIO.readGraph(csvPath, 9);
        System.out.println("=== GRAPH FROM CSV ===");
        System.out.println(graph);

        PerformanceTracker tracker = new PerformanceTracker();

        TarjanSCC tarjan = new TarjanSCC(tracker);
        SCCResult sccResult = tarjan.run(graph);

        System.out.println("=== SCC (Tarjan) ===");
        System.out.println("Found " + sccResult.count() + " strongly connected components.");
        for (List<Integer> component : sccResult.getComponents()) {
            System.out.println(component);
        }

        KahnTopologicalSort topoSort = new KahnTopologicalSort();
        TopologicalResult topoResult = topoSort.run(graph);

        if (topoResult == null) {
            System.out.println("Warning: The graph contains a cycle, topological sorting is not possible.");
        } else {
            System.out.println("=== Topological Sort (Kahn's Algorithm) ===");
            System.out.println(topoResult);
        }

        if (topoResult != null) {
            DAGShortestPath dagShortestPath = new DAGShortestPath();
            PathResult shortestPathResult = dagShortestPath.run(graph, 0);

            System.out.println("=== Shortest Path in DAG ===");
            for (int i = 0; i < graph.size(); i++) {
                System.out.println("Vertex " + i + ": Distance = " + shortestPathResult.dist[i]);
            }
        } else {
            System.out.println("The shortest paths algorithm was omitted due to the impossibility of topological sorting.");
        }

        if (topoResult != null) {
            DAGLongestPath dagLongestPath = new DAGLongestPath();
            PathResult longestPathResult = dagLongestPath.run(graph, 0);

            System.out.println("=== Longest Path (Critical Path) in DAG ===");
            for (int i = 0; i < graph.size(); i++) {
                System.out.println("Vertex " + i + ": Distance = " + longestPathResult.dist[i]);
            }
        } else {
            System.out.println("The algorithm of long paths was omitted due to the impossibility of topological sorting..");
        }

        System.out.println("=== Performance Metrics ===");
        System.out.println("Time elapsed: " + tracker.elapsedNanos() + " ns");
        System.out.println("DFS visits: " + tracker.get("dfs_visit"));
        System.out.println("DFS edges: " + tracker.get("dfs_edge"));


        System.out.println("\n=== Shortest Path in DAG ===");
        DAGShortestPath shortest = new DAGShortestPath();
        PathResult sp = shortest.run(graph, 0);
        if (sp != null) System.out.println(sp);

        System.out.println("\n=== Longest Path (Critical Path) in DAG ===");
        DAGLongestPath longest = new DAGLongestPath();
        PathResult lp = longest.run(graph, 0);
        if (lp != null) System.out.println(lp);



    }
}
