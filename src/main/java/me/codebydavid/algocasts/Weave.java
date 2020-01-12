package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.List;

// --- Directions
// 1) Complete the task in weave/queue.js
// 2) Implement the 'weave' function.  Weave
// receives two queues as arguments and combines the
// contents of each into a new, third queue.
// The third queue should contain the *alterating* content
// of the two queues.  The function should handle
// queues of different lengths without inserting
// 'undefined' into the new one.
// *Do not* access the array inside of any queue, only
// use the 'add', 'remove', and 'peek' functions.
// --- Example
//    const queueOne = new Queue();
//    queueOne.add(1);
//    queueOne.add(2);
//    const queueTwo = new Queue();
//    queueTwo.add('Hi');
//    queueTwo.add('There');
//    const q = weave(queueOne, queueTwo);
//    q.remove() // 1
//    q.remove() // 'Hi'
//    q.remove() // 2
//    q.remove() // 'There'
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