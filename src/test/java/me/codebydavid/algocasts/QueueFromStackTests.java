package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * QueueFromStackTests
 */
public class QueueFromStackTests {

    @Test
    public void testFirstInFirstOut() {
        QueueFromStack q = new QueueFromStack();
        q.add(1);
        q.add(2);
        q.add(3);
        assertEquals(1, q.remove());
        assertEquals(2, q.remove());
        assertEquals(3, q.remove());
    }

    @Test
    public void testPeek() {
        QueueFromStack q = new QueueFromStack();
        q.add(1);
        q.add(2);
        q.add(3);
        assertEquals(1, q.peek());
        assertEquals(1, q.remove());
        assertEquals(2, q.peek());
        assertEquals(2, q.remove());
        assertEquals(3, q.peek());
        assertEquals(3, q.remove());
    }
}