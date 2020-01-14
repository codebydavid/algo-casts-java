package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import me.codebydavid.algocasts.LevelWidth;
import me.codebydavid.algocasts.LevelWidth.Node;

/**
 * LevelWidthTests
 */
public class LevelWidthTests {

    @Test
    public void testLevelWidth() {
        Node root = new Node(0);
        root.add(1);
        root.add(2);
        root.add(3);

        root.children.get(0).add(4);
        root.children.get(2).add(5);
        
        int[] expected = new int[] {1, 3, 2}; 
        assertArrayEquals(expected, LevelWidth.levelWidth(root));
    }
}