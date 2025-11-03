package com.aitu.graph.chart;

import com.aitu.metrics.PerformanceTracker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class ChartGenerator {

        public static void generateTimeChart(PerformanceTracker tracker) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                dataset.addValue(tracker.elapsedNanos(), "Execution Time", "SCC");
                dataset.addValue(tracker.get("dfs_visit"), "Execution Time", "TopoSort");
                dataset.addValue(tracker.get("dfs_edge"), "Execution Time", "ShortestPath");

                JFreeChart chart = ChartFactory.createBarChart(
                        "Execution Time", "Algorithm", "Time (ns)", dataset);

                chart.setBackgroundPaint(Color.white);

                ChartPanel panel = new ChartPanel(chart);
                panel.setPreferredSize(new java.awt.Dimension(800, 600));
                panel.setMouseWheelEnabled(true);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);
        }
}
