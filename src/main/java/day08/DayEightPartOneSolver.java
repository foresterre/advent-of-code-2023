package day08;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import solution.Solver;

public class DayEightPartOneSolver implements Solver<Network> {
    static char LEFT = 'L';

    @Override
    public String solve(Network input) {
        var instructions = Stream.generate(input.instructions()).flatMapToInt(s -> s);
        var lookup = input.nodes();

        State initialState = new State(0, "AAA");

        AtomicBoolean ongoing = new AtomicBoolean(true);
        BiFunction<State, Character, State> f = (state, instruction) -> {
            if (state.current().equals("ZZZ")) {
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

        var fin = instructions
                    .takeWhile(_v -> ongoing.get()) // Probably not lazy :(
                    .mapToObj(c -> (char) c)
                    .reduce(initialState, f, State::merge);

        return String.valueOf(fin.counter());
    }

    private record State(int counter, String current){
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
