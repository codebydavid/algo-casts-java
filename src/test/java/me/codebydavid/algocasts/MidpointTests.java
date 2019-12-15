package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * MidpointTests
 */
public class MidpointTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(new Object[] {"a", "b", "c"}, "b"),
            Arguments.of(new Object[] {"a", "b", "c", "d", "e"}, "c"),
            Arguments.of(new Object[] {"a", "b"}, "a"),
            Arguments.of(new Object[] {"a", "b", "c", "d"}, "b")
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testMidpoint(Object[] values, Object expected) {
        LinkedList l = new LinkedList();
        for (Object data : values) {
            l.insertLast(data);
        }

        assertEquals(expected, Midpoint.midpoint(l).data);
    }
}