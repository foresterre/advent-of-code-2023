package day03;

import solution.Solver;

import java.util.Set;
import java.util.stream.Stream;

public class DayThreePartTwoSolver implements Solver<PartGrid> {
    @Override
    public String solve(PartGrid input) {
        Set<Part> parts = input.parts();

        Stream<Symbol> gears = input.symbols().stream().filter((symbol -> symbol.type() == '*'));

        var sum = gears
                .map((gear) -> parts.stream().filter((part -> part.isAdjacent(gear))).toList())
                .filter((list) -> list.size() == 2)
                .mapToInt((list) -> list.get(0).partNumber() * list.get(1).partNumber())
                .sum();


        return String.valueOf(sum);
    }
}
