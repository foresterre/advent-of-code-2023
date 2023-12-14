package day10;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10Test {
    private final int DAY = 10;

    @Test
    void part1_example() {
        var parser = new DayTenParser();
        var solver = new DayTenPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example");

        assertThat(answer).isEqualTo("4");
    }

    @Test
    void part1_example2() {
        var parser = new DayTenParser();
        var solver = new DayTenPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example2");

        assertThat(answer).isEqualTo("8");
    }

    @Test
    void part1() {
        var parser = new DayTenParser();
        var solver = new DayTenPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(DAY);

        // Solution part 1!
        assertThat(answer).isEqualTo("6927");
    }

    @Test
    void part2_example() {
        var parser = new DayTenParser();
        var solver = new DayTenPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example");

        assertThat(answer).isEqualTo("1");
    }

    @Test
    void part2_example3() {
        var parser = new DayTenParser();
        var solver = new DayTenPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example3");

        assertThat(answer).isEqualTo("4");
    }

    @Test
    void part2_example4() {
        var parser = new DayTenParser();
        var solver = new DayTenPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example4");

        assertThat(answer).isEqualTo("4");
    }

    @Test
    void part2_example5() {
        var parser = new DayTenParser();
        var solver = new DayTenPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(DAY, "example5");

        assertThat(answer).isEqualTo("8");
    }

    @Test
    void part2() {
        var parser = new DayTenParser();
        var solver = new DayTenPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(DAY);

        // Solution part 2!
        assertThat(answer).isEqualTo("todo");
    }
}
