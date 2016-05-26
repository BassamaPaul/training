/**
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public ListNode rotateRight(ListNode head, int k) {
  if (head == null || head.next == null || k == 0) {
      return head;
  }
  
  ListNode last = head;
  
  int length = 1;
  while (last.next != null) {
      length ++;
      last = last.next;
  }
  
  if (k % length == 0) {
      return head;
  } else if (length < k) {
      k %= length;
  }
  
  k = length - k;
  ListNode newLast = head;
  while (--k > 0) {
      newLast = newLast.next;
  }
  
  last.next = head;
  head = newLast.next;
  newLast.next = null;
  
  return head;
}
