package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * StackTests
 */
public class StackTests {

    @Test
    public void testFirstInLastOut() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.pop());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
    }

    @Test
    public void testPeek() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.peek());
        assertEquals(3, s.pop());
        assertEquals(2, s.peek());
        assertEquals(2, s.pop());
        assertEquals(1, s.peek());
        assertEquals(1, s.pop());
    }
}