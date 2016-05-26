/**
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

//works but not efficient, give time limit exeed from a certain data size
public void reorderList(ListNode head) {
    ListNode current = head;
    ListNode beforeLast = null;
    
    while (current != null && current.next != null) {
        beforeLast = current;
        while (beforeLast.next != null && beforeLast.next.next != null) {
            beforeLast = beforeLast.next;
        }
        
        if (current != beforeLast) {
            beforeLast.next.next = current.next;
            current.next = beforeLast.next;
            beforeLast.next = null;
        }
        
        current = current.next.next;
    }
}
