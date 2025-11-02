package com.aitu.io;

import com.aitu.core.DirectedGraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.*;

public final class JSONGraphIO {
    private JSONGraphIO() {}

    public static DirectedGraph readGraph(String path) throws IOException {
        String text = Files.readString(Path.of(path));
        int n = extractInt(text, "\"n\"\\s*:\\s*(\\d+)");
        DirectedGraph g = new DirectedGraph(n);

        Matcher m = Pattern.compile("\\{\\s*\"u\"\\s*:\\s*(\\d+)\\s*,\\s*\"v\"\\s*:\\s*(\\d+)\\s*,\\s*\"w\"\\s*:\\s*([0-9.]+)\\s*\\}")
                .matcher(text);
        while (m.find()) {
            int u = Integer.parseInt(m.group(1));
            int v = Integer.parseInt(m.group(2));
            double w = Double.parseDouble(m.group(3));
            g.addEdge(u, v, w);
        }
        return g;
    }

    private static int extractInt(String s, String regex) {
        Matcher m = Pattern.compile(regex).matcher(s);
        return m.find() ? Integer.parseInt(m.group(1)) : 0;
    }
}
