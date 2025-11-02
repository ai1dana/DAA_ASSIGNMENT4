package com.aitu.graph.topo;

import java.util.List;

public class TopologicalResult {
    private final List<Integer> order;

    public TopologicalResult(List<Integer> order) {
        this.order = order;
    }

    public List<Integer> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return order.toString();
    }
}

