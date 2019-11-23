package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * ReverseIntTest
 */
public class ReverseIntTest {

    @ParameterizedTest
    @CsvSource({
        "5, 5",
        "15, 51",
        "90, 9",
        "2359, 9532",
        "-5, -5",
        "-15, -51",
        "-90, -9",
        "-2359, -9532"
    })
    public void test(int n, int expected) {
        assertEquals(expected, ReverseInt.reverse(n));
    }
}