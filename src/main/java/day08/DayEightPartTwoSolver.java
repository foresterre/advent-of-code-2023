package day08;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import solution.Solver;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class DayEightPartTwoSolver implements Solver<Network> {
    static char LEFT = 'L';

    @Override
    public String solve(Network input) {
        var lookup = input.nodes();

        var commonStep = lookup.keySet().stream()
                .filter(key -> key.endsWith("A"))
                .map(key -> {
                    AtomicBoolean ongoing = new AtomicBoolean(true);
                    BiFunction<State, Character, State> f = (state, instruction) -> {
                        if (state.current().endsWith("Z")) {
                            ongoing.set(false);
                            return state;
                        }

                        var node = lookup.get(state.current());

                        if (instruction == LEFT) {
                            return state.incremented(node.left());
                        } else /* right */ {
                            return state.incremented(node.right());
                        }
                    };

                    var instructions = Stream.generate(input.instructions()).flatMapToInt(s -> s);
                    var node = lookup.get(key);
                    var initialState = new State(0, node.current());

                    var fin = instructions
                            .takeWhile(_v -> ongoing.get())
                            .mapToObj(c -> (char) c)
                            .reduce(initialState, f, State::merge);

                    return fin.counter;
                })
                .reduce(1L, this::lcm);


        return String.valueOf(commonStep);
    }

    private long lcm(long a, long b) {
        return a * b / LongMath.gcd(a, b);
    }

    private record State(long counter, String current){
        State incremented(String newCurrent) {
            return new State(this.counter + 1, newCurrent);
        }

        State merge(State other) {
            if (this.counter > other.counter) {
                return this;
            } else {
                return other;
            }
        }
    }
}
