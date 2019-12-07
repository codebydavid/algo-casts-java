package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * MatrixTests
 */
public class MatrixTests {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(2, new int[][] {
                {1, 2}, 
                {4, 3}
            }),
            Arguments.of(3, new int[][] {
                {1, 2, 3}, 
                {8, 9, 4}, 
                {7, 6, 5}
            }),
            Arguments.of(4, new int[][] {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
            }),
            Arguments.of(5, new int[][] {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
            })
        );
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testMatrix1(int n, int[][] expected) {
        int[][] actual = Matrix.matrix1(n);

        assertEquals(n, actual.length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testMatrix2(int n, int[][] expected) {
        int[][] actual = Matrix.matrix2(n);

        assertEquals(n, actual.length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

}
