package com.aitu.metrics;

public interface Metrics {
    void reset();

    void start();

    void stop();

    long elapsedNanos();

    void inc(String counter);

    long get(String counter);
}
