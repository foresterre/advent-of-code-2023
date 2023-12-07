package day03;

import java.util.Comparator;

public record Coordinate(int x, int y) implements Comparable<Coordinate> {
    @Override
    public int compareTo(Coordinate other) {
        return Comparator.comparingInt(Coordinate::x)
                .thenComparingInt(Coordinate::y)
                .compare(this, other);
    }
}
