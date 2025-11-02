package com.aitu.core;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {
    private final int n;
    private final List<List<Edge>> adj;

    public DirectedGraph(int n) {
        this.n = n;
        this.adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, double w) {
        if (u < 0 || u >= n || v < 0 || v >= n) {
            throw new IllegalArgumentException("Error: the vertex is out of range (u=" + u + ", v=" + v + ")");
        }
        adj.get(u).add(new Edge(u, v, w));
    }

    public List<Edge> edgesFrom(int u) {
        if (u < 0 || u >= n) {
            throw new IllegalArgumentException("Error: the vertex is out of range (u=" + u + ")");
        }
        return adj.get(u);
    }

    public int size() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i).append(": ").append(adj.get(i)).append("\n");
        }
        return sb.toString();
    }
}
