package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * FibTests
 */
public class FibTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(4, 3),
            Arguments.of(39, 63245986)
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testFib1(int n, int expected) {
        long t0 = System.currentTimeMillis();
        int actual = Fib.fib1(n);
        long duration = System.currentTimeMillis() - t0;

        assertEquals(expected, actual
            , "Correct fib number for " + n + " is " + expected);

        System.out.println("[Fib::fib1] Fib value for " + n + " calculated in " + duration + " ms");
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testFib2(int n, int expected) {
        long t0 = System.currentTimeMillis();
        int actual = Fib.fib2(n);
        long duration = System.currentTimeMillis() - t0;

        assertEquals(expected, actual
            , "Correct fib number for " + n + " is " + expected);

        System.out.println("[Fib::fib2] Fib value for " + n + " calculated in " + duration + " ms");
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testFib3(int n, int expected) {
        long t0 = System.currentTimeMillis();
        int actual = Fib.fib3(n);
        long duration = System.currentTimeMillis() - t0;

        assertEquals(expected, actual
            , "Correct fib number for " + n + " is " + expected);

        System.out.println("[Fib::fib3] Fib value for " + n + " calculated in " + duration + " ms");
    }
}