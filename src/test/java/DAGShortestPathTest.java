package com.aitu.graph.dagsp;

import com.aitu.core.DirectedGraph;
import com.aitu.graph.topo.KahnTopologicalSort;
import com.aitu.graph.topo.TopologicalResult;
import com.aitu.io.CSVGraphIO;
import com.aitu.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DAGShortestPathTest {

    @Test
    void testDAGShortestPath() throws Exception {
        PerformanceTracker tracker = new PerformanceTracker();

        DirectedGraph graph = CSVGraphIO.readGraph("data/inputs/sample_graph.csv", 9);

        KahnTopologicalSort topoSort = new KahnTopologicalSort();
        TopologicalResult topoResult = topoSort.run(graph);

        if (topoResult == null) {
            System.out.println("Error: The graph contains a cycle. Shortcuts are impossible.");
        } else {
            DAGShortestPath dagShortestPath = new DAGShortestPath();
            PathResult result = dagShortestPath.run(graph, 0);

            assertNotNull(result, "DAG shortest path result should not be null");
            assertEquals(0.0, result.dist[0], "Distance from 0 to 0 should be 0");
            assertTrue(result.dist[1] > 0, "Distance from 0 to 1 should be positive");
        }
    }
}
