package me.codebydavid.algocasts;

// --- Directions
// 1) Implement the Node class to create
// a binary search tree.  The constructor
// should initialize values 'data', 'left',
// and 'right'.
// 2) Implement the 'insert' method for the
// Node class.  Insert should accept an argument
// 'data', then create an insert a new node
// at the appropriate location in the tree.
// 3) Implement the 'contains' method for the Node
// class.  Contains should accept a 'data' argument
// and return the Node in the tree with the same value.

public class BinarySearchTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void insert(int data) {
            if (data < this.data) {
                if (this.left != null) {
                    this.left.insert(data);
                } else {
                    this.left = new Node(data);
                }
            } else {
                if (this.right != null) {
                    this.right.insert(data);
                } else {
                    this.right = new Node(data);
                }
            }
        }

        public Node contains(int data) {
            if (data == this.data) return this;

            if (data < this.data && this.left != null) {
                return this.left.contains(data);
            } else if (data > this.data && this.right != null) {
                return this.right.contains(data);
            }

            return null;
        }
    }

}
