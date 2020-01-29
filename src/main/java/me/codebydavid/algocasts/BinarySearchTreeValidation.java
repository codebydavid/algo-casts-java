package me.codebydavid.algocasts;

import me.codebydavid.algocasts.BinarySearchTree.Node;

// --- Directions
// Given a node, validate the binary search tree,
// ensuring that every node's left hand child is
// less than the parent node's value, and that
// every node's right hand child is greater than
// the parent

public class BinarySearchTreeValidation {

    public static boolean validate(Node node, Integer min, Integer max) {
        if (node == null) return true;

        // if the value of current node is less than the min return false
        if (min != null && min > node.data) return false;

        // if the value of current node is greater than the max return false
        if (max != null && max < node.data) return false;

        // check the children
        return 
            validate(node.left, min, node.data) // left node should be less than current 
            && validate(node.right, node.data, max); // right node should be greater than current
    }
    
}
