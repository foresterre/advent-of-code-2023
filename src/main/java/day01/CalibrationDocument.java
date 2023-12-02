package day01;


import java.util.List;

/**
 * Maps a certain line (of type Integer) to a set of calibration numbers.
 *
 * @param values A collection of calibration values.
 */
public record CalibrationDocument(List<CalibrationValue> values) {
    public int sum() {
        return values.stream()
                .mapToInt(CalibrationValue::calibrationValue)
                .sum();
    }
}
