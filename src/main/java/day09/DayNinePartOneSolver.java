package day09;

import solution.Solver;

import java.util.*;

public class DayNinePartOneSolver implements Solver<int[][]> {
    @Override
    public String solve(int[][] input) {
        var predictors = new ArrayDeque<Integer>();

        for (int[] history : input) {
            while (Arrays.stream(history).anyMatch(value -> value != 0)) {
                var predictor = history[history.length - 1];

                predictors.add(predictor);
                history = stepDifference(history);
            }
        }

        var sum = predictors.reversed().stream().mapToInt(v->v).sum();

        return String.valueOf(sum);
    }


    //  missing Rust here 🥲, where is my slice::windows :)
    private int[] stepDifference(int[] input) {
        int[] result = new int[input.length - 1];

        for (int i = 0; i < input.length - 1; i++) {
            result[i] = input[i+1] - input[i];
        }

        return result;
    }
}
