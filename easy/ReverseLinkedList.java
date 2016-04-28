/*
reverse Linked list
*/

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode current = head;
    ListNode previous = null;
    ListNode temp;
    
    while (current != null) {
        temp = current.next;
        current.next = previous;
        previous = current;
        current = temp;
    }
    
    return previous;
}
