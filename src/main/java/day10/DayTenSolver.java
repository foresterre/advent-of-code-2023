package day10;

import solution.Solver;

import java.util.*;

public class DayTenSolver implements Solver<Survey> {
    @Override
    public String solve(Survey input) {
        var graph = input.graph();
        var start = input.start();

        Queue<Vertex> queue = new ArrayDeque<>();
        Map<Vertex, Integer> distances = new HashMap<>();

        queue.add(start);
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            var currentDistance = distances.get(current);

            for (var successor : graph.get(current)) {
                if (!distances.containsKey(successor)) {
                    queue.add(successor);
                    distances.put(successor, currentDistance + 1);
                }
            }
        }

        var furthest = distances.values().stream().mapToInt(Integer::intValue).max().orElseThrow();

        return String.valueOf(furthest);
    }
}
