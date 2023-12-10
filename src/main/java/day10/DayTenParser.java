package day10;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayTenParser implements Parse<Survey> {
    @Override
    public Survey from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        String[] rows = reader.lines().toArray(String[]::new);
        int rowsBound = rows.length;
        int colsBound = rows[0].length();

        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        AtomicReference<Vertex> start = new AtomicReference<>(null);

        IntStream.range(0, rows.length)
                .forEach(row -> {
                    IntStream.range(0, rows[row].length())
                            .forEach(col -> {
                                char c = rows[row].charAt(col);
                                Vertex vertex = new Vertex(col, row);

                                switch (c) {
                                    case 'S' -> {
                                        start.set(vertex);
                                    }
                                    case '|' -> {
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col, row - 1));
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col, row + 1));
                                    }
                                    case '-' -> {
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col - 1, row));
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col + 1, row));
                                    }
                                    case 'L' -> {
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col, row - 1));
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col + 1, row));
                                    }
                                    case 'J' -> {
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col, row - 1));
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col - 1, row));
                                    }
                                    case '7' -> {
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col, row + 1));
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col - 1, row));
                                    }
                                    case 'F' -> {
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col, row + 1));
                                        addEdge(graph, rowsBound, colsBound, vertex, new Vertex(col + 1, row));
                                    }
                                }

                            });
                });


        var startNode = start.get();

        // find start nodes
        var startConnections = graph.entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(vertex -> vertex.equals(startNode)))
                .map(Map.Entry::getKey)
                .toList();

        // add start nodes to graph
        startConnections.forEach(vertex -> addEdge(graph, rowsBound, colsBound, startNode, vertex));


        return new Survey(graph, startNode);
    }

    private static void addEdge(Map<Vertex, List<Vertex>> graph, int rowsBound, int colsBound, Vertex from, Vertex to) {
        if (insideBounds(rowsBound, colsBound, to.x(), to.y())) {
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
            } else {
                graph.put(from, new ArrayList<>(List.of(to)));
            }
        }
    }

    // Check if the position is within the grid boundaries
    private static boolean insideBounds(int rowsBound, int colsBound, int row, int col) {
        return row >= 0 && row < rowsBound && col >= 0 && col < colsBound;
    }
}
