/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;
    if (head.next == null && n == 1) return null;
    
    List<ListNode> nodes = new ArrayList<>();
    ListNode current = head;
    
    while (current != null) {
        nodes.add(current);
        current = current.next;
    }
    
    int indexNodeToRemove = nodes.size() - n;
    if (indexNodeToRemove == 0) {
        return nodes.get(1);
    } else {
        nodes.get(indexNodeToRemove - 1).next = nodes.get(indexNodeToRemove).next;
        return nodes.get(0);
    }
}
