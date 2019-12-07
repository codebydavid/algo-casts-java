package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * VowelsTests
 */
public class VowelsTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of("aeiou", 5),
            Arguments.of("AEIOU", 5),
            Arguments.of("abcdefghijklmnopqrstuvwxyz", 5),
            Arguments.of("bcdfghjkl", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testVowels1(String str, int expected) {
        assertEquals(expected, Vowels.vowels1(str));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testVowels2(String str, int expected) {
        assertEquals(expected, Vowels.vowels2(str));
    }
}