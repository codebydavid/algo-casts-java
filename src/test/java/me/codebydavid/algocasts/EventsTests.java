package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import me.codebydavid.algocasts.Events.Callback;

/**
 * EventsTests
 */
public class EventsTests {

    @Test
    public void testOneCallback() {
        Events events = new Events();

        MockCallback cb1 = new MockCallback();
        
        events.on("click", cb1);
        events.trigger("click");

        assertEquals(1, cb1.calls);
    }

    @Test
    public void testMultipleCallbacks() {
        Events events = new Events();

        MockCallback cb1 = new MockCallback();
        MockCallback cb2 = new MockCallback();
        
        events.on("click", cb1);
        events.on("click", cb2);

        events.trigger("click");

        assertEquals(1, cb1.calls);
        assertEquals(1, cb2.calls);
    }

    @Test
    public void testTriggerMultipleTimes() {
        Events events = new Events();

        MockCallback cb1 = new MockCallback();
        MockCallback cb2 = new MockCallback();
        
        events.on("click", cb1);
        events.trigger("click");
        events.on("click", cb2);
        events.trigger("click");
        events.trigger("click");

        assertEquals(3, cb1.calls);
        assertEquals(2, cb2.calls);
    }

    @Test
    public void testDifferentEvents() {
        Events events = new Events();

        MockCallback cb1 = new MockCallback();
        MockCallback cb2 = new MockCallback();

        events.on("click", cb1);
        events.trigger("click");
        events.on("hover", cb2);
        events.trigger("click");
        events.trigger("hover");

        assertEquals(2, cb1.calls);
        assertEquals(1, cb2.calls);        
    }

    @Test
    public void testToggleOffEvents() {
        Events events = new Events();

        MockCallback cb1 = new MockCallback();
        MockCallback cb2 = new MockCallback();

        events.on("hover", cb2);

        events.on("click", cb1);
        events.trigger("click");
        events.off("click");
        events.trigger("click");

        events.trigger("hover");

        assertEquals(1, cb1.calls);
        assertEquals(1, cb2.calls);        
    }

    class MockCallback implements Callback {
        public int calls = 0;

        @Override
        public void execute() {
            calls++;
        }
    }

}