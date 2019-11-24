package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * FizzBuzzTests
 */
public class FizzBuzzTests {

    private static Stream<Arguments> getTestArguments() {
        return Stream.of(
            Arguments.of(5, new String[] {
                "1", 
                "2", 
                "fizz", 
                "4", 
                "buzz"
            }),
            Arguments.of(15, new String[] {
                "1", 
                "2", 
                "fizz", 
                "4", 
                "buzz",
                "fizz",
                "7",
                "8",
                "fizz",
                "buzz",
                "11",
                "fizz",
                "13",
                "14",
                "fizzbuzz"
            })
        );
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testFizzBuzz(int n, String[] expected) {
        String[] actual = FizzBuzz.fizzBuss(n);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}