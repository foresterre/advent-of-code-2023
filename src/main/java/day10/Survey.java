package day10;

import java.util.List;
import java.util.Map;

public record Survey(Map<Vertex, List<Vertex>> graph, Vertex start) {
}
