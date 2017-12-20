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

//
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode prev = null;
    ListNode c1 = l1;
    ListNode c2 = l2;

    while (c1 != null && c2 != null) {
        if (c1.val > c2.val) {
            ListNode node = new ListNode(c2.val);
            if (prev == null) {
                node.next = l1;
                l1 = node;
                c1 = l1;
            } else {
                node.next = prev.next;
                prev.next = node;
                prev = prev.next;
            }
            c2 = c2.next;
        } else {
            prev = c1;
            c1 = c1.next;
        }
    }

    while (c2 != null) {
        prev.next = new ListNode(c2.val);
        prev = prev.next;
        c2 = c2.next;
    }
    return l1;
}
