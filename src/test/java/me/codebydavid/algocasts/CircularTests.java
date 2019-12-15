package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import me.codebydavid.algocasts.LinkedList.Node;

/**
 * CircularTests
 */
public class CircularTests {

    @Test
    public void testCircular1() {
        LinkedList l = new LinkedList();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        l.head = a;
        a.next = b;
        b.next = c;
        c.next = b;

        assertEquals(true, Circular.circular(l));
    }

    @Test
    public void testCircular2() {
        LinkedList l = new LinkedList();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        l.head = a;
        a.next = b;
        b.next = c;
        c.next = a;

        assertEquals(true, Circular.circular(l));
    }

    @Test
    public void testCircular3() {
        LinkedList l = new LinkedList();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        l.head = a;
        a.next = b;
        b.next = c;
        c.next = null;

        assertEquals(false, Circular.circular(l));
    }
}