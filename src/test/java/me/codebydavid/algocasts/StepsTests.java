package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * StepsTests
 */
public class StepsTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(1, new String[]{ "#" }),
            Arguments.of(2, new String[]{ "# ", "##" }),
            Arguments.of(3, new String[]{ "#  ", "## ", "###" })
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testSteps1(int n, String[] expected) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));

        Steps.steps1(n);

        String[] actual = baos.toString().split("\r\n|[\r\n]");

        System.setOut(out);

        assertEquals(expected.length, actual.length,
            "Expected " + n + " println() outputs.");
        for (int i = 0; i < n; i++) {
            assertEquals(expected[i], actual[i]);
        };
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testSteps2(int n, String[] expected) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));

        Steps.steps2(n);

        String[] actual = baos.toString().split("\r\n|[\r\n]");

        System.setOut(out);

        assertEquals(expected.length, actual.length,
            "Expected " + n + " println() outputs.");
        for (int i = 0; i < n; i++) {
            assertEquals(expected[i], actual[i]);
        };
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testSteps3(int n, String[] expected) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));

        Steps.steps3(n);

        String[] actual = baos.toString().split("\r\n|[\r\n]");

        System.setOut(out);

        assertEquals(expected.length, actual.length,
            "Expected " + n + " println() outputs.");
        for (int i = 0; i < n; i++) {
            assertEquals(expected[i], actual[i]);
        };
    }
}
