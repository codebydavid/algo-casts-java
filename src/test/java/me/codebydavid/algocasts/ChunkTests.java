package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * ChunkTests
 */
public class ChunkTests {

    private static Stream<Arguments> getTestArguments() {
        return Stream.of(
            Arguments.of(
                new Integer[] {1, 2, 3}, 1, 
                new Integer[][] {{1}, {2}, {3}}),
            Arguments.of(
                new Integer[] {1, 2, 3, 4, 5}, 3, 
                new Integer[][] {{1, 2, 3}, {4, 5}}),
            Arguments.of(
                new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, 5, 
                new Integer[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13}})
        );
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testChunk1(Integer[] array, int size, Integer[][] expected) {
        Integer[][] actual = Chunk.chunk1(array, size);
        assertEquals(expected.length, actual.length);
        //assertTrue(Arrays.equals(expected, actual));
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("getTestArguments")
    public void testChunk2(Integer[] array, int size, Integer[][] expected) {
        Integer[][] actual = Chunk.chunk2(array, size);
        assertEquals(expected.length, actual.length);
        //assertTrue(Arrays.equals(expected, actual));
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}