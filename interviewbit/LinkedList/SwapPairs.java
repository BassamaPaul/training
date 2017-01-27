/**
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
public ListNode swapPairs(ListNode a) {
    if (a == null || a.next == null)
        return a;

    ListNode prev = null;
    ListNode current = a;
    ListNode next = current.next;

    current.next = next.next;
    next.next = current;

    a = next;

    while (current.next != null && current.next.next != null) {
        prev = current;
        current = current.next;
        next = current.next;

        current.next = next.next;
        next.next = current;
        prev.next = next;
    }

    return a;
}
