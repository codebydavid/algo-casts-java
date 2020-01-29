package me.codebydavid.algocasts;

import static me.codebydavid.algocasts.BinarySearchTreeValidation.validate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import me.codebydavid.algocasts.BinarySearchTree.Node;

/**
 * BinarySearchTreeValidationTests
 */
public class BinarySearchTreeValidationTests {

    @Test
    public void testValidBST() {
        Node n = new Node(10);
        n.insert(5);
        n.insert(15);
        n.insert(0);
        n.insert(20);

        assertEquals(true, validate(n, null, null));
    }

    @Test
    public void testInvalidBST() {
        Node n = new Node(10);
        n.insert(5);
        n.insert(15);
        n.insert(0);
        n.insert(20);
        n.left.left.right = new Node(999);

        assertEquals(false, validate(n, null, null));
    }

}
