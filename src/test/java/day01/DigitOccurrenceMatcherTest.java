package day01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DigitOccurrenceMatcherTest {
    @Test
    void spelled_out_digits_false_none_present() {
        var input = "1abc2";

        var matcher = new DigitOccurrenceMatcher(false);

        var first = matcher.findFirstMatching(input);
        var last = matcher.findLastMatching(input);

        assertThat(first).isEqualTo(1);
        assertThat(last).isEqualTo(2);
    }

    @Test
    void spelled_out_digits_false_some_present() {
        var input = "4nineeight2seven";

        var matcher = new DigitOccurrenceMatcher(false);

        var first = matcher.findFirstMatching(input);
        var last = matcher.findLastMatching(input);

        assertThat(first).isEqualTo(4);
        assertThat(last).isEqualTo(2);
    }

    @Test
    void spelled_out_digits_true_some_present() {
        var input = "4nineeight2seven";

        var matcher = new DigitOccurrenceMatcher(true);

        var first = matcher.findFirstMatching(input);
        var last = matcher.findLastMatching(input);

        assertThat(first).isEqualTo(4);
        assertThat(last).isEqualTo(7);
    }

    @Test
    void overlapping_spelled_out_digits() {
        var input = "twotwone";

        var matcher = new DigitOccurrenceMatcher(true);

        var first = matcher.findFirstMatching(input);
        var last = matcher.findLastMatching(input);

        assertThat(first).isEqualTo(2);
        assertThat(last).isEqualTo(1);
    }

}
