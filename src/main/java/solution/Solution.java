package solution;

import reader.DayReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public record Solution<T>(Parse<T> parse, Solver<T> solver) {
    public String runDay(int day) {
        try(var contents = DayReader.readDay(day)) {
            T parsed = parse.from(contents);

            return solver.solve(parsed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String runFile(int day, String resourceFileName) {
        try(var contents = DayReader.readFile(day, resourceFileName)) {
            T parsed = parse.from(contents);

            return solver.solve(parsed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String runString(String input) {
        var inputStream = new ByteArrayInputStream(input.getBytes());

        T parsed = parse.from(inputStream);

        return solver.solve(parsed);

    }
}
