package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import me.codebydavid.algocasts.Tree.Node;

/**
 * TreeTests
 */
public class TreeTests {

    @Test
    public void testNodeConstructor() {
        Node node = new Node('a');
        assertEquals('a', node.data);
        assertEquals(0, node.children.length);
    }

    @Test
    public void testNodeAdd() {
        Node node = new Node('a');
        node.add('b');
        node.add('c');
        assertEquals(2, node.children.length);
        assertEquals('b', node.children[0].data);
        assertEquals('c', node.children[1].data);
    }

    @Test
    public void testNodeRemove() {
        Node node = new Node('a');
        node.add('b');
        node.add('c');
        assertEquals(2, node.children.length);
        assertEquals('b', node.children[0].data);
        node.remove('b');
        assertEquals(1, node.children.length);
        assertEquals('c', node.children[0].data);
    }

    @Test
    public void testTreeConstructor() {
        Tree tree = new Tree();
        assertEquals(null, tree.root);
    }

    @Test
    public void testTreeTraverseBF() {
        List<Integer> result = new ArrayList<Integer>();

        Node root = new Node(0);
        root.add(1);
        root.add(2);
        root.add(3);
        root.children[0].add(4);
        root.children[2].add(5);
        Tree tree = new Tree();
        tree.root = root;

        tree.traverseBF(node -> result.add((Integer)node.data));

        Integer[] expected = {0, 1, 2, 3, 4, 5};
        Integer[] actual = result.toArray(new Integer[result.size()]);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testTreeTraverseDF() {
        List<Integer> result = new ArrayList<Integer>();

        Node root = new Node(0);
        root.add(1);
        root.add(2);
        root.add(3);
        root.children[0].add(4);
        root.children[2].add(5);
        Tree tree = new Tree();
        tree.root = root;

        tree.traverseDF(node -> result.add((Integer)node.data));

        Integer[] expected = {0, 1, 4, 2, 3, 5};
        Integer[] actual = result.toArray(new Integer[result.size()]);
        assertArrayEquals(expected, actual);
    }
}