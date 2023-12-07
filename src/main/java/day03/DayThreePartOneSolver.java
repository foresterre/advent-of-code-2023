package day03;

import solution.Solver;

import java.util.Set;

public class DayThreePartOneSolver implements Solver<PartGrid> {
    @Override
    public String solve(PartGrid input) {
        Set<Part> parts = input.parts();
        Set<Symbol> symbols = input.symbols();

        var sum = parts.stream().filter((part) -> symbols.stream().anyMatch(part::isAdjacent))
                .mapToInt(Part::partNumber).sum();

        return String.valueOf(sum);
    }
}
