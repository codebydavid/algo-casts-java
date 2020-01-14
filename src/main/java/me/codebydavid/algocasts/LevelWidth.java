package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.List;

// --- Directions
// Given the root node of a tree, return
// an array where each element is the width
// of the tree at each level.
// --- Example
// Given:
//     0
//   / |  \
// 1   2   3
// |       |
// 4       5
// Answer: [1, 3, 2]
public class LevelWidth {

    public static int[] levelWidth(Node root) {
        // Java array can't resize dynamically so use List instead
        List<Integer> counters = new ArrayList<Integer>();
        counters.add(0);

        // Use a queue to control the order of processing
        List<Object> queue = new ArrayList<Object>();
        queue.add(root);
        queue.add("s"); // use "s" to indicate the end of a level
        while (queue.size() > 1) { // if queue size is 1, then "s" must be the remaining element
            Object val = queue.remove(0); // remove an element to the processed
            if (val.equals("s")) {
                // when element is "s" that means all elements of
                // current level have been counted and children have 
                // been added. Add "s" to the end of queue to indicate the
                // end of the child level. Add a 0 to counters to initialize
                // the count for the child level.
                queue.add(val);
                counters.add(0);
            } else {
                // for regular nodes, add the children to the queue
                Node node = (Node)val;
                queue.addAll(node.children);

                // increment the counter by 1.
                // current counter is at the end of the counters list.
                int last = counters.size() - 1;
                counters.set(last, counters.get(last) + 1);
            }
        }

        int[] widths = new int[counters.size()];
        for (int i = 0; i < counters.size(); i++) {
            widths[i] = counters.get(i).intValue();
        }

        return widths;
    }

    public static class Node {
        Object value;
        public List<Node> children;

        public Node(Object value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public void add(Object value) {
            this.children.add(new Node(value));
        }
    }
}