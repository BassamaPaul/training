/**
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

public ListNode deleteDuplicates(ListNode head) {
  if (head == null || head.next == null) {
      return head;
  }
  
  ListNode current = head;
  ListNode previous = null;
  
  while (current != null && current.next != null) {
      if (head.val == head.next.val) {
          head.next = head.next.next;
          if (head.next == null || head.val != head.next.val) {
              head = head.next;
              current = head;
          }
      } else if (current.val == current.next.val) {
          current.next = current.next.next;
          if (current.next == null || current.val != current.next.val) {
              previous.next = current.next;
              current = current.next;
          }
      } else {
          previous = current;
          current = current.next;
      }
  }
  
  return head;
}
