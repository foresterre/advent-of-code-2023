package day02;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {

    @Test
    void part1_example() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("2_example.txt");

        assertThat(answer).isEqualTo("8");
    }

    @Test
    void part1() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(2);

        // Solution part 1!
        assertThat(answer).isEqualTo("2164");
    }

    @Test
    void part2_example() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("2_example.txt");

        assertThat(answer).isEqualTo("2286");
    }

    @Test
    void part2() {
        var parser = new DayTwoParser();
        var solver = new DayTwoPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(2);

        // Solution part 2!
        assertThat(answer).isEqualTo("69929");
    }
}
