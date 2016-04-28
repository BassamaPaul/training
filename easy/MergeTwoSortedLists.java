/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    else if (l2 == null) return l1;
    
    ListNode current1 = l1;
    ListNode current2 = l2;
    ListNode newHead;
    ListNode current;
    
    if (current1.val > current2.val) {
        newHead = new ListNode(current2.val);
        current2 = current2.next;
    } else {
        newHead = new ListNode(current1.val);
        current1 = current1.next;
    }
    
    current = newHead;
    
    while (current1 != null && current2 != null) {
        if (current1.val > current2.val) {
            current.next = new ListNode(current2.val);
            current2 = current2.next;
        } else {
            current.next = new ListNode(current1.val);
            current1 = current1.next;
        }
        current = current.next;
    }
    
    if (current1 != null) current.next = current1;
    if (current2 != null) current.next = current2;
    
    return newHead;
}
