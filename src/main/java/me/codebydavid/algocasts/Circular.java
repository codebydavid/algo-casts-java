package me.codebydavid.algocasts;

import me.codebydavid.algocasts.LinkedList.Node;

// --- Directions
// Given a linked list, return true if the list
// is circular, false if it is not.
// --- Examples
//   const l = new List();
//   const a = new Node('a');
//   const b = new Node('b');
//   const c = new Node('c');
//   l.head = a;
//   a.next = b;
//   b.next = c;
//   c.next = b;
//   circular(l) // true
public class Circular {

    // Solution
    //   Use 2 pointers advancing at different speeds.
    //   If the list is circular then eventually both
    //   pointers will point to the same node.
    public static boolean circular(LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while (fast != null && 
               fast.next != null && 
               fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            // if both pointers are at the same node then list is circular
            // NOTE: compare the node object references, not the data values
            if (slow == fast) return true;
        }

        // list is not circular if pointers reach the end of the list
        return false;
    }
}