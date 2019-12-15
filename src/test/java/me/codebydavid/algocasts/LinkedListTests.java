package me.codebydavid.algocasts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * LinkedListTests
 */
public class LinkedListTests {

    @Test
    public void testInsertFirst() {
        LinkedList list = new LinkedList();

        list.insertFirst(1);
        assertEquals(1, list.head.data);

        list.insertFirst(2);
        assertEquals(2, list.head.data);
    }

    @Test
    public void testSize() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);
        assertEquals(4, list.size());
    }

    @Test
    public void testGetFirst() {
        LinkedList list = new LinkedList();
        list.insertFirst(1);
        assertEquals(1, list.getFirst().data);
        list.insertFirst(2);
        assertEquals(2, list.getFirst().data);
    }

    @Test
    public void testGetLast() {
        LinkedList list = new LinkedList();
        assertEquals(null, list.getLast());
        list.insertFirst(1);
        assertEquals(1, list.getLast().data);
        list.insertFirst(2);
        assertEquals(1, list.getLast().data);
    }

    @Test
    public void testClear() {
        LinkedList list = new LinkedList();
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);
        list.insertFirst(1);
        assertEquals(4, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveFirst() {
        LinkedList list = new LinkedList();
        list.insertFirst("c");
        list.insertFirst("b");
        list.insertFirst("a");
        list.removeFirst();
        assertEquals(2, list.size());
        assertEquals("b", list.getFirst().data);
        list.removeFirst();
        assertEquals(1, list.size());
        assertEquals("c", list.getFirst().data);
    }

    static Stream<Arguments> getRemoveLastArguments() {
        return Stream.of(
            Arguments.of(new String[0], 0, null),
            Arguments.of(new String[] {"a"}, 0, null),
            Arguments.of(new String[] {"b", "a"}, 1, "a"),
            Arguments.of(new String[] {"c", "b", "a"}, 2, "b")
        );
    }

    @ParameterizedTest
    @MethodSource("getRemoveLastArguments")
    public void testRemoveLast(Object[] values, int expectedSize, Object expected) {
        LinkedList list = new LinkedList();

        for (Object data : values) {
            list.insertFirst(data);
        }

        list.removeLast();

        assertEquals(expectedSize, list.size());

        LinkedList.Node last = list.getLast(); 
        assertEquals(expected, (expected != null ? last.data : last));
    }

    @Test
    public void testInsertLast() {
        LinkedList list = new LinkedList();

        list.insertFirst("a");
        list.insertLast("b");

        assertEquals(2, list.size());
        assertEquals("b", list.getLast().data);
    }

    @Test
    public void testGetAt() {
        LinkedList list = new LinkedList();

        assertEquals(null, list.getAt(10));

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);

        assertEquals(1, list.getAt(0).data);
        assertEquals(2, list.getAt(1).data);
        assertEquals(3, list.getAt(2).data);
        assertEquals(4, list.getAt(3).data);
    }


    static Stream<Arguments> getRemoveAtArguments() {
        return Stream.of(
            // empty list
            Arguments.of(new Object[0], 0, null, null),
            Arguments.of(new Object[0], 1, null, null),
            Arguments.of(new Object[0], 2, null, null),
            // index out of bound
            Arguments.of(new Object[] {"a"}, 1, null, null),
            // first node
            Arguments.of(new Object[] {1, 2, 3, 4}, 0, 1, 2),
            // given index
            Arguments.of(new Object[] {1, 2, 3, 4}, 1, 2, 3),
            // last node
            Arguments.of(new Object[] {1, 2, 3, 4}, 3, 4, null)
        );
    }

    @ParameterizedTest
    @MethodSource("getRemoveAtArguments")
    public void testRemoveAt(Object[] values, int index, 
        Object expectedBefore, Object expectedAfter) 
    {
        LinkedList l = new LinkedList();

        for (Object data : values) {
            l.insertLast(data);
        }

        assertEquals(expectedBefore,
            expectedBefore == null ? l.getAt(index) : l.getAt(index).data);

        l.removeAt(index);

        assertEquals(expectedAfter, 
            expectedAfter == null ? l.getAt(index) : l.getAt(index).data);
    }

    static Stream<Arguments> getInsertAtArguments() {
        return Stream.of(
            // insert at 0 of an empty list
            Arguments.of(new Object[] {}, "hi", 0, new Object[] {"hi"}),
            // insert at 0 of a non-empty list
            Arguments.of(new Object[] {"a", "b", "c"}, "hi", 0, new Object[] {"hi", "a", "b", "c"}),
            // insert in the middle
            Arguments.of(new Object[] {"a", "b", "c", "d"}, "hi", 2, new Object[] {"a", "b", "hi", "c", "d"}),
            // insert at last index
            Arguments.of(new Object[] {"a", "b"}, "hi", 2, new Object[] {"a", "b", "hi"}),
            // insert when index is out of bound
            Arguments.of(new Object[] {"a", "b"}, "hi", 30, new Object[] {"a", "b", "hi"})
        );
    }

    @ParameterizedTest
    @MethodSource("getInsertAtArguments")
    public void testInsertAt(
        Object[] values, Object data, int index, Object[] expected)
    {
        LinkedList l = new LinkedList();

        for (Object value : values) {
            l.insertLast(value);
        }

        l.insertAt(data, index);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], l.getAt(i).data);
        }
    }

    @Test
    public void testForEach() {
        LinkedList l = new LinkedList();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);

        l.forEach(node -> node.data = (int)node.data + 10);

        assertEquals(11, l.getAt(0).data);
        assertEquals(12, l.getAt(1).data);
        assertEquals(13, l.getAt(2).data);
        assertEquals(14, l.getAt(3).data);
    }

    @Test
    public void testForEachLoop() {
        LinkedList l = new LinkedList();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);


        for (LinkedList.Node node : l) {
            node.data = (int)node.data + 10;
        }

        assertEquals(11, l.getAt(0).data);
        assertEquals(12, l.getAt(1).data);
        assertEquals(13, l.getAt(2).data);
        assertEquals(14, l.getAt(3).data);
    }
}