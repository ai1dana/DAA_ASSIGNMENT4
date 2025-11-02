package com.aitu.metrics;

import java.util.HashMap;
import java.util.Map;

public class PerformanceTracker implements Metrics {
    private long start, elapsed;
    private final Map<String, Long> counters = new HashMap<>();

    @Override
    public void reset() {
        elapsed = 0;
        counters.clear();
    }

    @Override
    public void start() {
        start = System.nanoTime();
    }

    @Override
    public void stop() {
        elapsed += System.nanoTime() - start;
    }

    @Override
    public long elapsedNanos() {
        return elapsed;
    }

    @Override
    public void inc(String name) {
        counters.merge(name, 1L, Long::sum);
    }

    @Override
    public long get(String name) {
        return counters.getOrDefault(name, 0L);
    }

    public Map<String, Long> snapshot() {
        return new HashMap<>(counters);
    }
}
