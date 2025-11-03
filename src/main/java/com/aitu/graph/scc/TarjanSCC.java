package com.aitu.graph.scc;

import com.aitu.core.DirectedGraph;
import com.aitu.core.Edge;
import com.aitu.metrics.PerformanceTracker;

import java.util.*;

public class TarjanSCC {
    private int[] tin, low;
    private boolean[] onStack;
    private Deque<Integer> stack;
    private int timer;
    private final PerformanceTracker metrics;

    public TarjanSCC(PerformanceTracker metrics) {
        if (metrics == null) {
            throw new IllegalArgumentException("PerformanceTracker must not be null.");
        }
        this.metrics = metrics;
        this.stack = new ArrayDeque<>();
    }

    public SCCResult run(DirectedGraph g) {
        int n = g.size();
        tin = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        Arrays.fill(tin, -1);
        timer = 0;
        SCCResult result = new SCCResult();

        metrics.reset();
        metrics.start();

        for (int v = 0; v < n; v++) {
            if (tin[v] == -1) {
                dfs(v, g, result);
            }
        }
        metrics.stop();
        return result;
    }

    private void dfs(int v, DirectedGraph g, SCCResult result) {
        metrics.inc("dfs_visit");
        tin[v] = low[v] = timer++;
        stack.push(v);
        onStack[v] = true;

        for (Edge e : g.edgesFrom(v)) {
            metrics.inc("dfs_edge");
            int to = e.getTo();
            if (tin[to] == -1) {
                dfs(to, g, result);
                low[v] = Math.min(low[v], low[to]);
            } else if (onStack[to]) {
                low[v] = Math.min(low[v], tin[to]);
            }
        }

        if (low[v] == tin[v]) {
            List<Integer> component = new ArrayList<>();
            while (true) {
                int u = stack.pop();
                onStack[u] = false;
                component.add(u);
                if (u == v) break;
            }
            result.addComponent(component);
        }
    }
}
