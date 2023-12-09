package day09;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DayNineParser implements Parse<int[][]> {
    @Override
    public int[][] from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        return reader.lines()
                .map(line -> Splitter.on(" ").splitToStream(line).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }
}
