package me.codebydavid.algocasts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

// --- Directions
// 1) Create a node class.  The constructor
// should accept an argument that gets assigned
// to the data property and initialize an
// empty array for storing children. The node
// class should have methods 'add' and 'remove'.
// 2) Create a tree class. The tree constructor
// should initialize a 'root' property to null.
// 3) Implement 'traverseBF' and 'traverseDF'
// on the tree class.  Each method should accept a
// function that gets called with each element in the tree
public class Tree {

    Node root;

    public void traverseBF(Consumer<Node> fn) {
        // use an array list to keep track of the nodes to work through
        List<Node> l = new ArrayList<Node>();
        // start with root node
        l.add(root);

        // loop while the array list is not empty
        while (l.size() > 0) {
            // remove the first element of the list
            Node node = l.remove(0);

            // add children to the end of the list
            // so sibling nodes are processed first
            l.addAll(Arrays.asList(node.children));

            // apply function
            fn.accept(node);
        }
    }

    public void traverseDF(Consumer<Node> fn) {
        // use an array list to keep track of the nodes to work through
        List<Node> l = new ArrayList<Node>();
        // start with root node
        l.add(root);

        // loop while the array list is not empty
        while (l.size() > 0) {
            // remove the first element of the list
            Node node = l.remove(0);

            // add children to the end of the list
            // so sibling nodes are processed first
            l.addAll(0, Arrays.asList(node.children));

            // apply function
            fn.accept(node);
        }
    }

    public static class Node {
        Object data;
        Node[] children;

        public Node(Object data) {
            this.data = data;
            this.children = new Node[0];
        }

        public void add(Object data) {
            List<Node> l = new ArrayList<Node>(Arrays.asList(this.children));
            l.add(new Node(data));
            this.children = l.toArray(new Node[l.size()]);
        }

        public void remove(Object data) {
            Stream<Node> filtered = Arrays.stream(this.children)
                .filter(node -> node.data != data);
            this.children = filtered.toArray(Node[]::new);
        }
    }
}