package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * CapitalizeTests
 */
public class CapitalizeTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(
                "hi there, how is it going?", "Hi There, How Is It Going?"
            ),
            Arguments.of(
                "i love breakfast at bill miller bbq", "I Love Breakfast At Bill Miller Bbq"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testCapitalize1(String str, String expected) {
        assertEquals(expected, Capitalize.capitalize1(str));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testCapitalize2(String str, String expected) {
        assertEquals(expected, Capitalize.capitalize2(str));
    }

}
