package day03;

import day02.DayTwoParser;
import day02.DayTwoPartOneSolver;
import day02.DayTwoPartTwoSolver;
import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03Test {
    @Test
    void part1_example() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("3_example.txt");

        assertThat(answer).isEqualTo("4361");
    }

    @Test
    void part1() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(3);

        // Solution part 1!
        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2_example() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("3_example.txt");

        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(3);

        // Solution part 2!
        assertThat(answer).isEqualTo("todo");
    }
}
