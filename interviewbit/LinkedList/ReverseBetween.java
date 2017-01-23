/**
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
*/

public ListNode reverseBetween(ListNode a, int m, int n) {
    if (a == null || a.next == null || m == n) 
        return a;

    int countBegin = 1;
    ListNode current = a;
    ListNode fixPrevious = null;

    while (countBegin < m && current != null) {
        fixPrevious = current;
        current = current.next;
        countBegin++;
    }

    if (current == null) return a;

    int countEnd = countBegin;
    ListNode prev = current;
    current = current.next;
    while (current != null && countEnd < n) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        countEnd ++;
    }

    if (fixPrevious == null) {
        a.next = current;
        a = prev;
    } else {
        fixPrevious.next.next = current;
        fixPrevious.next = prev;
    }

    return a;
}
