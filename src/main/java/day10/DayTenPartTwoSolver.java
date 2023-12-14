package day10;

import solution.Solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DayTenPartTwoSolver implements Solver<Survey> {


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

        // find the minimum x and y values in input.graph() and find the maximum x and y values in input.graph()
//        int minX = distances.keySet().stream().min(Comparator.comparingInt(Vertex::x)).map(Vertex::x).orElseThrow();
//        int minY = distances.keySet().stream().min(Comparator.comparingInt(Vertex::y)).map(Vertex::y).orElseThrow();
        int maxX = input.grid()[0].length(); // distances.keySet().stream().max(Comparator.comparingInt(Vertex::x)).map(Vertex::x).orElseThrow();
        int maxY = input.grid().length; // distances.keySet().stream().max(Comparator.comparingInt(Vertex::y)).map(Vertex::y).orElseThrow();

        // use the loopElements to find the surface within the loop
        // the graph exists within a 2D plane
        // the surface is not necessarily rectangular

        var grid = input.grid();
        var count = 0;



        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                var currentVertex = new Vertex(x, y);
                if (!distances.containsKey(currentVertex)) {
                    input.markOutside(currentVertex);
                    // insides will be overwritten later
                } else {
                    // part of loop!
                    char c = grid[currentVertex.y()].charAt(currentVertex.x());

                    switch (c) {
                        case 'S' -> input.markChar(currentVertex, 'S');
                        case '|' -> input.markChar(currentVertex, '┃');
                        case '-' -> input.markChar(currentVertex, '━');
                        case 'L' -> input.markChar(currentVertex, '┗');
                        case 'J' -> input.markChar(currentVertex, '┛');
                        case '7' -> input.markChar(currentVertex, '┓');
                        case 'F' -> input.markChar(currentVertex, '┏');
                        default -> input.markChar(currentVertex, c);
                    }
                }
            }
        }

        // x -> inside y
        boolean[] insideY = new boolean[maxX];


        for (int y = 0; y < maxY; y++) {
            boolean insideX = false;
            for (int x = 0; x < maxX; x++) {
                var c = grid[y].charAt(x);
                var currentVertex = new Vertex(x, y);

                // We "bracket count" the surface within the loop
                switch (c) {
                    case 'L' -> {
                        // ┗
                        insideY[x] = !insideY[x];
                        insideX = !insideX;
                    }
                    case 'J' -> {
                        // ┛
                        insideY[x] = !insideY[x];
                        insideX = !insideX;
                    }
                    case '7' -> {
                        // ┓
                        insideY[x] = !insideY[x];
                        insideX = !insideX;
                    }
                    case 'F' -> {
                        // ┏
                        insideY[x] = !insideY[x];
                        insideX = !insideX;
                    }
                    case '-' -> {
                        if (distances.containsKey(currentVertex)) {
                            insideY[x] = !insideY[x];
                        }
                    }
                    case '|' -> {
                        // only count the surface if we are inside the loop
                        // there may be other walls pipes that are not part of the loop
                        if (distances.containsKey(currentVertex)) {
                            insideX = !insideX;
                        }
                    }
                    case '.' -> {
                        if (insideY[x] && insideX) {
//                            System.out.println((x+1) + ", " + (y+1) + " is inside the loop !!!!");
                            count += 1;
                            input.markInside(currentVertex);
//                            System.out.println(currentVertex + " " + c);
                        }
                    }
                }


            }
        }

        // dbg
        try {
            Files.write(Paths.get("dbg.txt"), input.toString().lines().toList(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.valueOf(count);
    }
}
