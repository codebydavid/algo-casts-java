package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * MaxCharTests
 */
public class MaxCharTests {

    private static Stream<Arguments> getTestArguments() {
        return Stream.of(
            Arguments.of("a", 'a'),
            Arguments.of("abcdefghijklmnaaaaa", 'a'),
            Arguments.of("ab1c1d1e1f1g1", '1')
        );
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testMaxChar1(String str, char expected) {
        assertEquals(expected, MaxChar.maxChar1(str));
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testMaxChar2(String str, char expected) {
        assertEquals(expected, MaxChar.maxChar2(str));
    }
}