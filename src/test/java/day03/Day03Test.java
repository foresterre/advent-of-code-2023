package day03;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03Test {
    @Test
    void part1_example() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(3, "example");

        assertThat(answer).isEqualTo("4361");
    }

    @Test
    void none() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123.
.....""");

        assertThat(answer).isEqualTo("0");
    }

    @Test
    void lhs() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
*123.
.....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void rhs() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123*
.....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void up_0() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
*....
.123.
.....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void up_1() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.*...
.123.
.....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void up_2() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
..*..
.123.
.....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void up_3() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
...*.
.123.
.....""");

        assertThat(answer).isEqualTo("123");
    }


    @Test
    void up_4() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
....*
.123.
.....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void down_0() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123.
*....""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void down_1() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123.
.*...""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void down_2() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123.
..*..""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void down_3() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123.
...*.""");

        assertThat(answer).isEqualTo("123");
    }

    @Test
    void down_4() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runString("""
.....
.123.
....*""");

        assertThat(answer).isEqualTo("123");
    }


    @Test
    void part1() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(3);

        // Solution part 1!
        assertThat(answer).isEqualTo("543867");
    }

    @Test
    void part2_example() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(3, "example");

        assertThat(answer).isEqualTo("467835");
    }

    @Test
    void part2() {
        var parser = new DayThreeParser();
        var solver = new DayThreePartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(3);

        // Solution part 2!
        assertThat(answer).isEqualTo("79613331");
    }
}
