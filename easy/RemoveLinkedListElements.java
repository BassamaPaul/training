/**
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
        return null;
    }
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head.val == val? head.next : head;
}
