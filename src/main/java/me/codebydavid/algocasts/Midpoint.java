package me.codebydavid.algocasts;

import me.codebydavid.algocasts.LinkedList.Node;

// --- Directions
// Return the 'middle' node of a linked list.
// If the list has an even number of elements, return
// the node at the end of the first half of the list.
// *Do not* use a counter variable, *do not* retrieve
// the size of the list, and only iterate
// through the list one time.
// --- Example
//   const l = new LinkedList();
//   l.insertLast('a')
//   l.insertLast('b')
//   l.insertLast('c')
//   midpoint(l); // returns { data: 'b' }
public class Midpoint {

    // Solution: 
    // find midpoint using a slow pointer that moves at half 
    // the distance as the fast pointer
    public static Node midpoint(LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        // check if there are enough nodes for fast pointer to advance
        while (fast != null &&
               fast.next != null &&
               fast.next.next != null)
        {
            // slow pointer moves at 1 node at a time
            slow = slow.next;

            // while fast pointer moves at 2 nodes at a time
            fast = fast.next.next;
        }

        return slow;
    }
}