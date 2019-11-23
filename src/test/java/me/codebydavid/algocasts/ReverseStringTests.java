package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReverseStringTests {

    private static Stream<Arguments> createTestArguments() {
        return Stream.of(
            Arguments.of("ABC", "CBA"),
            Arguments.of(" A B C ", " C B A "),
            Arguments.of("XYZ ABC", "CBA ZYX")
        );
    }

    @ParameterizedTest
    @MethodSource("createTestArguments")
    void testSolution1(String str, String expected) {
        assertEquals(expected, ReverseString.reverse1(str));
    }

    @ParameterizedTest
    @MethodSource("createTestArguments")
    void testSolution2(String str, String expected) {
        assertEquals(expected, ReverseString.reverse2(str));
    }

    @ParameterizedTest
    @MethodSource("createTestArguments")
    void testSolution3(String str, String expected) {
        assertEquals(expected, ReverseString.reverse3(str));
    }

}
