package me.codebydavid.algocasts;

import java.util.Iterator;

/**
 * LinkedList
 */
public class LinkedList implements Iterable<LinkedList.Node> {

    public Node head = null;

    public void insertFirst(Object data) {
        this.head = new Node(data, this.head);
    }

    public int size() {
        int counter = 0;
        Node node = this.head;

        while (node != null) {
            counter++;
            node = node.next;
        }

        return counter;
    }

    public Node getFirst() {
        return this.head;
    }

    public Node getLast() {
        Node node = this.head;
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void clear() {
        this.head = null;
    }

    public void removeFirst() {
        if (this.head != null) {
            this.head = this.head.next;
        }
    }

    public void removeLast() {
        // empty list
        if (this.head == null) return;

        // list of 1
        if (this.head.next == null) {
            this.head = null;
            return;
        }

        Node prev = this.head;
        Node node = this.head.next;

        // find the last node
        while (node.next != null) {
            prev = node;
            node = node.next;
        }

        // remove last by setting "next" reference of prev node to null
        prev.next = null;
    }

    public void insertLast(Object data) {
        Node last = getLast();

        if (last == null) {
            // last is null when list is empty
            this.head = new Node(data);
        } else {
            last.next = new Node(data);
        }
    }

    public Node getAt(int index) {
        int counter = 0;
        Node node = this.head;

        while (node != null) {
            // return the node when counter matches index
            if (counter == index) {
                return node;
            }

            // move on to next node
            node = node.next;

            // increment counter
            counter++;
        }

        // return null as default
        // code will only reach this point if
        // counter never matched index
        return null;
    }

    public void removeAt(int index) {
        // removing first
        if (index == 0 && this.head != null) {
            this.head = this.head.next;
            return;
        }

        Node prev = getAt(index - 1);
        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    public void insertAt(Object data, int index) {
        // empty list
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }

        // insert at 0
        if (index == 0) {
            this.head = new Node(data, this.head);
            return;
        }

        // middle
        Node prev = this.getAt(index - 1);
        if (prev != null) {
            prev.next = new Node(data, prev.next);
        } else {
            // out of bound, add to the end
            this.getLast().next = new Node(data);
        }
    }

    /* 
    // NOTE: 
    //   in order to implement "for-each" exercise, this class must
    //   implement "Iterable" interface which came with default implementation
    //   of forEach. The code is left here, to demonstrate how forEach could be
    //   implementated without Iterable.
    public void forEach(Consumer<Node> f) {
        for (Node node = this.head; node != null; node = node.next) {
            f.accept(node);
        }
    }
    */

    @Override
    public Iterator<Node> iterator() {
        return new LinkedListIterator(this);
    }

    public static class Node {
        public Object data;
        public Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this(data, null);
        }
    }

    class LinkedListIterator implements Iterator<Node> {
        Node node = null; // current node

        public LinkedListIterator(LinkedList list) {
            // start at the head node
            this.node = list.head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Node next() {
            Node next = node;
            if (node != null) node = node.next;
            return next;
        }
    }
}