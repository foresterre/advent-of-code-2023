package day08;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import solution.Parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

public class DayEightParser implements Parse<Network> {
    @Override
    public Network from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        try {
            var instructions = reader.readLine();
            reader.readLine();

            var nodes = reader.lines()
                    .map(line -> {
                        var splitter = Splitter
                                .on(CharMatcher.anyOf("=(,)"))
                                .trimResults()
                                .omitEmptyStrings()
                                .split(line);
                        var iterator = splitter.iterator();

                        var currentNode = iterator.next();
                        var leftNode = iterator.next();
                        var rightNode = iterator.next();

                        return new Node(currentNode, leftNode, rightNode);
                    })
                    .filter(node -> !Objects.equals(node.current(), node.left()) && !node.current().equals(node.right()))
                    .collect(Collectors.toMap(Node::current, n -> n));

            return new Network(instructions::chars, nodes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
