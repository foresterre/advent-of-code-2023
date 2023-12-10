package day10;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10Test {
    private final int DAY = 10;

    @Test
    void part1_example() {
        var parser = new DayTenParser();
        var solver = new DayTenSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example");

        assertThat(answer).isEqualTo("4");
    }

    @Test
    void part1_example2() {
        var parser = new DayTenParser();
        var solver = new DayTenSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example2");

        assertThat(answer).isEqualTo("8");
    }

    @Test
    void part1() {
        var parser = new DayTenParser();
        var solver = new DayTenSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(DAY);

        // Solution part 1!
        assertThat(answer).isEqualTo("6927");
    }

    @Test
    void part2_example() {
        var parser = new DayTenParser();
        var solver = new DayTenSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example");

        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2() {
        var parser = new DayTenParser();
        var solver = new DayTenSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(DAY);

        // Solution part 2!
        assertThat(answer).isEqualTo("todo");
    }
}
