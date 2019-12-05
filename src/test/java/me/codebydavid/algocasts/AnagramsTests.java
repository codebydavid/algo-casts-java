package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * AnagramTests
 */
public class AnagramsTests {

    static final String ANAGRAMS_MESSAGE = "\"%1$s\" and \"%2$s\" are anagrams.";
    static final String NOT_ANAGRAMS_MESSAGE = "\"%1$s\" and \"%2$s\" are not anagrams.";

    static String getMessage(Boolean expected, String stringA, String stringB) {
        return String.format(
            expected ? ANAGRAMS_MESSAGE : NOT_ANAGRAMS_MESSAGE,
            stringA, stringB);
    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of("hello", "llohe", Boolean.TRUE),
            Arguments.of("Whoa! Hi!", "Hi! Whoa!!", Boolean.TRUE),
            Arguments.of("One One", "Two two two", Boolean.FALSE),
            Arguments.of("One one", "One one c", Boolean.FALSE),
            Arguments.of("A tree, a life, a bench", "A tree, a fence, a yard", Boolean.FALSE)
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testAnagrams1(final String stringA, final String stringB, final Boolean expected) {
        assertEquals(expected, Anagrams.anagrams1(stringA, stringB),
            getMessage(expected, stringA, stringB));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testAnagrams2(final String stringA, final String stringB, final Boolean expected) {
        assertEquals(expected, Anagrams.anagrams2(stringA, stringB),
            getMessage(expected, stringA, stringB));
    }
}
