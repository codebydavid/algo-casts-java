package me.codebydavid.algocasts;

import me.codebydavid.algocasts.LinkedList.Node;

// --- Directions
// Given a linked list, return the element n spaces
// from the last node in the list.  Do not call the 'size'
// method of the linked list.  Assume that n will always
// be less than the length of the list.
// --- Examples
//    const list = new List();
//    list.insertLast('a');
//    list.insertLast('b');
//    list.insertLast('c');
//    list.insertLast('d');
//    fromLast(list, 2).data // 'b'
public class FromLast {

    // Solution
    //   Use 2 pointers, slow & fast. Keep fast "n" nodes ahead of slow.
    //   When fast pointer reaches the end of th list, slow would be the result
    public static LinkedList.Node fromLast(LinkedList list, int n) {
        Node slow = list.head;
        Node fast = list.head;

        // move fast to "n" nodes ahead of slow
        for (int i = 0; i < n; i++) {
            if (fast != null) fast = fast.next;
        }

        // advance both pointers 1 node at a time until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow would be "n" nodes from the end when fast.next is null
        return slow;
    }
}