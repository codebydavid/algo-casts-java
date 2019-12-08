package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * WeaveTests
 */
public class WeaveTests {

    @Test
    public void testPeek() {
        Weave.Queue q = new Weave.Queue();
        q.add(1);
        q.add(2);
        assertEquals(1, q.peek());
        assertEquals(1, q.peek());
    }

    @Test
    public void testWeave() {
        Weave.Queue one = new Weave.Queue();
        one.add(1);
        one.add(2);
        one.add(3);
        one.add(4);
        Weave.Queue two = new Weave.Queue();
        two.add("one");
        two.add("two");
        two.add("three");
        two.add("four");

        Weave.Queue result = Weave.weave(one, two);
        assertEquals(1, result.remove());
        assertEquals("one", result.remove());
        assertEquals(2, result.remove());
        assertEquals("two", result.remove());
        assertEquals(3, result.remove());
        assertEquals("three", result.remove());
        assertEquals(4, result.remove());
        assertEquals("four", result.remove());
        assertEquals(null, result.remove());
    } 
}