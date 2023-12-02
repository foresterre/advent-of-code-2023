package day01;


import solution.Solver;

public class DayOneSolver implements Solver<CalibrationDocument> {
    @Override
    public String solve(CalibrationDocument document) {
        return String.valueOf(document.sum());
    }
}
