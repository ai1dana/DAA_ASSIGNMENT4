package com.aitu.graph.scc;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import com.aitu.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SCCTest {

    @Test
    void testTarjanSCC() throws Exception {
        PerformanceTracker tracker = new PerformanceTracker();

        DirectedGraph graph = CSVGraphIO.readGraph("data/inputs/sample_graph.csv", 9);

        TarjanSCC tarjan = new TarjanSCC(tracker);
        SCCResult result = tarjan.run(graph);

        assertNotNull(result, "SCC should not be null");
        assertEquals(1, result.count(), "There should be 1 strongly connected component");
    }
}
