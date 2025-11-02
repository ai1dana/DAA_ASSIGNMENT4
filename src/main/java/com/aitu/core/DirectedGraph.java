package com.aitu.core;

import java.util.*;

public class DirectedGraph {
    private final int n;
    private final List<List<Edge>> adj;

    public DirectedGraph(int n) {
        this.n = n;
        this.adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int from, int to, double weight) {
        adj.get(from).add(new Edge(from, to, weight));
    }

    public List<Edge> edgesFrom(int v) { return adj.get(v); }

    public int size() { return n; }

    public int edgeCount() {
        return adj.stream().mapToInt(List::size).sum();
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

