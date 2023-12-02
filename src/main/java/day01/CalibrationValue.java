package day01;

public record CalibrationValue(int first, int second) {
        public int calibrationValue() {
            String concatenated = String.valueOf(first) + second;
            return Integer.parseInt(concatenated);
        }
}
