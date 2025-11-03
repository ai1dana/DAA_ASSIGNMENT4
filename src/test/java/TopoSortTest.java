package com.aitu.graph.topo;

import com.aitu.core.DirectedGraph;
import com.aitu.io.CSVGraphIO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopoSortTest {

    @Test
    void testKahnTopologicalSort() throws Exception {
        DirectedGraph graph = CSVGraphIO.readGraph("data/inputs/sample_graph.csv", 9);

        KahnTopologicalSort topoSort = new KahnTopologicalSort();
        TopologicalResult result = topoSort.run(graph);

        if (result == null) {
            System.out.println("The graph contains a cycle, topological sorting is not possible.");
        } else {
            assertNotNull(result, "Topological sort result should not be null");
            assertEquals(9, result.getOrder().size(), "Topological sort order should contain all vertices");
        }
    }
}
