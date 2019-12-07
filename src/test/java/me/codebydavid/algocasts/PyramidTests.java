package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * PyramidTests
 */
public class PyramidTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(1, new String[] { "#" }),
            Arguments.of(2, new String[] { " # ", "###" }),
            Arguments.of(3, new String[] { "  #  ", " ### ", "#####" }),
            Arguments.of(4, new String[] { "   #   ", "  ###  ", " ##### ", "#######" })
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testPyramid1(int n, String[] expected) {
        // redirect standard out
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        // call solution
        Pyramid.pyramid1(n);

        // parse standard outputs
        String[] actual = baos.toString().split("\r\n|[\r\n]");

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < n; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testPyramid2(int n, String[] expected) {
        // redirect standard out
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        // call solution
        Pyramid.pyramid2(n);

        // parse standard outputs
        String[] actual = baos.toString().split("\r\n|[\r\n]");

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < n; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}