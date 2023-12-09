package day09;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09Test {
    private final int DAY = 9;

    @Test
    void part1_example() {
        var parser = new DayNineParser();
        var solver = new DayNinePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example");

        assertThat(answer).isEqualTo("114");
    }

    @Test
    void part1() {
        var parser = new DayNineParser();
        var solver = new DayNinePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(DAY);

        // Solution part 1!
        assertThat(answer).isEqualTo("2105961943");
    }

    @Test
    void part2_example() {
        var parser = new DayNineParser();
        var solver = new DayNinePartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example");

        assertThat(answer).isEqualTo("2");
    }

    @Test
    void part2() {
        var parser = new DayNineParser();
        var solver = new DayNinePartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(DAY);

        // Solution part 2!
        assertThat(answer).isEqualTo("1019");
    }
}
