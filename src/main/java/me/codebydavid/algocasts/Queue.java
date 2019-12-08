package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.List;

// --- Description
// Create a queue data structure.  The queue
// should be a class with methods 'add' and 'remove'.
// Adding to the queue should store an element until
// it is removed
// --- Examples
//     const q = new Queue();
//     q.add(1);
//     q.remove(); // returns 1;
public class Queue {

    // member variable can be initialized without the constructor in Java
    private List<Integer> data = new ArrayList<Integer>();

    /**
     * Adds the record to the beginning of the array like in Javascript exercise
     */
    void add(int record) {
        // add to beginning of array by adding at index 0
        data.add(0, record);
    }

    /**
     * Remove the last element in the array like the Javascript exercise
     */
    public int remove() {
        // remove the end by specifying the last index
        return data.remove(data.size() - 1);
    }
}