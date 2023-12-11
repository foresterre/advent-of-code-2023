package day11;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class DayElevenParser implements Parse<GalaxyMap> {
    @Override
    public GalaxyMap from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        String[] rows = reader.lines().toArray(String[]::new);

        var galaxies = IntStream.range(0, rows.length)
                .mapToObj(row -> IntStream.range(0, rows[row].length())
                        .filter(col -> rows[row].charAt(col) == '#')
                        .mapToObj(col -> new Galaxy(col, row))
                )
                .flatMap(s -> s)
                .toList();


        int width = rows[0].length();
        int height = rows.length;

        return new GalaxyMap(galaxies, width, height);
    }
}
