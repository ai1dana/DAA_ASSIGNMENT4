package com.aitu.graph.dagsp;

import java.util.Arrays;



public class PathResult {
    public final double[] dist;
    public final int[] prev;

    public PathResult(int n) {
        dist = new double[n];
        prev = new int[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        Arrays.fill(prev, -1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist.length; i++) {
            sb.append("Vertex ").append(i)
                    .append(": Distance = ").append(dist[i])
                    .append(", Prev = ").append(prev[i]).append("\n");
        }
        return sb.toString();
    }
}
