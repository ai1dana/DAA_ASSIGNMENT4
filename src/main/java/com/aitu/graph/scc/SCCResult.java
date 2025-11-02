package com.aitu.graph.scc;

import java.util.ArrayList;
import java.util.List;

public class SCCResult {
    private final List<List<Integer>> components = new ArrayList<>();

    public void addComponent(List<Integer> component) {
        components.add(component);
    }

    public List<List<Integer>> getComponents() {
        return components;
    }

    public int count() {
        return components.size();
    }
}
