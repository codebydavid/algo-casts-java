package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import me.codebydavid.algocasts.BinarySearchTree.Node;

/**
 * BinarySearchTreeTests
 */
public class BinarySearchTreeTests {

    @Test
    public void testInsert() {
        Node node = new Node(10);
        node.insert(5);
        node.insert(15);
        node.insert(17);

        assertEquals(5, node.left.data);
        assertEquals(15, node.right.data);
        assertEquals(17, node.right.right.data);
    }
    
    @Test
    public void testContainsExpected() {
        Node node = new Node(10);
        node.insert(5);
        node.insert(15);
        node.insert(20);
        node.insert(0);
        node.insert(-5);
        node.insert(3);

        Node three = node.left.left.right;
        assertEquals(three, node.contains(3));
    }

    @Test
    public void testContainsNull() {
        Node node = new Node(10);
        node.insert(5);
        node.insert(15);
        node.insert(20);
        node.insert(0);
        node.insert(-5);
        node.insert(3);

        assertEquals(null, node.contains(9999));
    }
}