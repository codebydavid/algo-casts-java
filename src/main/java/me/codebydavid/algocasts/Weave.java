package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.List;

/**
 * Weave
 */
public class Weave {

    public static Queue weave(Queue sourceOne, Queue sourceTwo) {
        Queue q = new Queue();

        while (sourceOne.peek() != null || sourceTwo.peek() != null) {
            if (sourceOne.peek() != null) q.add(sourceOne.remove());
            if (sourceTwo.peek() != null) q.add(sourceTwo.remove());
        }

        return q;
    }
    
    // Queue inner class
    public static class Queue {
        private List<Object> data = new ArrayList<Object>();

        public void add(Object record) {
            this.data.add(0, record);
        }

        public Object remove() {
            try {
                return this.data.remove(this.data.size() - 1);
            } catch (ArrayIndexOutOfBoundsException ex) {
                // return null if queue is empty
                return null;
            }
        }

        public Object peek() {
            try {
                return this.data.get(this.data.size() - 1);
            } catch (ArrayIndexOutOfBoundsException ex) {
                // return null if queue is empty
                return null;
            }
        }
    }
}