package day08;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public record Network(Supplier<IntStream> instructions, Map<String, Node> nodes) {
}
