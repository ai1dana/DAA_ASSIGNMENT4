package com.aitu.graph.test;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import com.aitu.graph.dagsp.DAGShortestPath;
import com.aitu.graph.dagsp.DAGLongestPath;
import com.aitu.graph.dagsp.PathResult;
import com.aitu.graph.topo.KahnTopologicalSort;
import com.aitu.graph.topo.TopologicalResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphPerformanceTest {

    @Test
    void testSmallGraphs() throws Exception {
        for (int i = 6; i <= 10; i++) {
            DirectedGraph graph = CSVGraphIO.readGraph("data/inputs/small_graph_" + i + ".csv", i);
            System.out.println("Testing Small Graph " + i + " vertices");

            KahnTopologicalSort topoSort = new KahnTopologicalSort();
            TopologicalResult topoResult = topoSort.run(graph);

            if (topoResult == null) {
                System.out.println("Warning: The graph contains a cycle. Skipping shortest and longest path algorithms.");
                continue;


            }

            DAGShortestPath dagShortestPath = new DAGShortestPath();
            PathResult shortestPathResult = dagShortestPath.run(graph, 0);
            assertNotNull(shortestPathResult, "Shortest Path result should not be null");

            DAGLongestPath dagLongestPath = new DAGLongestPath();
            PathResult longestPathResult = dagLongestPath.run(graph, 0);
            assertNotNull(longestPathResult, "Longest Path result should not be null");
        }
    }

    @Test
    void testMediumGraphs() throws Exception {
        for (int i = 10; i <= 20; i++) {
            DirectedGraph graph = CSVGraphIO.readGraph("data/inputs/medium_graph_" + i + ".csv", i);
            System.out.println("Testing Medium Graph " + i + " vertices");

            KahnTopologicalSort topoSort = new KahnTopologicalSort();
            TopologicalResult topoResult = topoSort.run(graph);

            if (topoResult == null) {
                System.out.println("Warning: The graph contains a cycle. Skipping shortest and longest path algorithms.");
                continue;
            }

            DAGShortestPath dagShortestPath = new DAGShortestPath();
            PathResult shortestPathResult = dagShortestPath.run(graph, 0);
            assertNotNull(shortestPathResult, "Shortest Path result should not be null");

            DAGLongestPath dagLongestPath = new DAGLongestPath();
            PathResult longestPathResult = dagLongestPath.run(graph, 0);
            assertNotNull(longestPathResult, "Longest Path result should not be null");
        }
    }

    @Test
    void testLargeGraphs() throws Exception {
        for (int i = 20; i <= 50; i++) {
            DirectedGraph graph = CSVGraphIO.readGraph("data/inputs/large_graph_" + i + ".csv", i);
            System.out.println("Testing Large Graph " + i + " vertices");

            KahnTopologicalSort topoSort = new KahnTopologicalSort();
            TopologicalResult topoResult = topoSort.run(graph);

            if (topoResult == null) {
                System.out.println("Warning: The graph contains a cycle. Skipping shortest and longest path algorithms.");
                continue;
            }

            DAGShortestPath dagShortestPath = new DAGShortestPath();
            PathResult shortestPathResult = dagShortestPath.run(graph, 0);
            assertNotNull(shortestPathResult, "Shortest Path result should not be null");

            DAGLongestPath dagLongestPath = new DAGLongestPath();
            PathResult longestPathResult = dagLongestPath.run(graph, 0);
            assertNotNull(longestPathResult, "Longest Path result should not be null");
        }
    }
}
