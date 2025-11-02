package com.aitu.graph.dagsp;

public class PathResult {
    public double[] dist;
    public int[] parent;
    public int source;

    public double[] getDist() {
        return dist;
    }

    public int[] getParent() {
        return parent;
    }
}
