package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * FromLastTests
 */
public class FromLastTests {

    @Test
    public void testFromLast() {
        LinkedList l = new LinkedList();

        l.insertLast("a");
        l.insertLast("b");
        l.insertLast("c");
        l.insertLast("d");
        l.insertLast("e");

        assertEquals("b", FromLast.fromLast(l, 3).data);
    }
}