package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * QueueTests
 */
public class QueueTests {

    @Test
    public void testAdd() {
        Queue q = new Queue();
        q.add(1);
    }

    @Test
    public void testRemove() {
        Queue q = new Queue();
        q.add(1);
        q.remove();
    }

    @Test
    public void testOrder() {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        assertEquals(1, q.remove());
        assertEquals(2, q.remove());
        assertEquals(3, q.remove());
    }
}