package com.aitu.metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PerformanceTrackerCSV {

    public static void saveMetricsToCSV(PerformanceTracker tracker, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Metric,Value\n");

            Map<String, Long> metrics = tracker.snapshot();
            for (Map.Entry<String, Long> entry : metrics.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            writer.flush();
        }
    }
}

