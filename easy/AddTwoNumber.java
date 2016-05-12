/**
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  if (l1 == null && l2 == null) {
      return null;
  } else if (l1 == null) {
      return l2;
  } else if (l2 == null) {
      return l1;
  }
  
  ListNode current1 = l1;
  ListNode current2 = l2;
  
  int sum = 0;
  int flag = 0;
  
  ListNode result = null;
  ListNode currentResult = null;
  
  while (current1 != null || current2 != null) {
      sum = 0;
      if (current1 != null) {
          sum = current1.val;
          current1 = current1.next;
      }
      
      if (current2 != null) {
          sum += current2.val;
          current2 = current2.next;
      }
      
      sum += flag;
      
      if (sum > 9) {
          sum %= 10;
          flag = 1;
      } else {
          flag = 0;
      }
      
      if (result == null) {
          result = new ListNode(sum);
          currentResult = result;
      } else {
          currentResult.next = new ListNode(sum);
          currentResult = currentResult.next;
      }
  }
  
  if (flag == 1) {
      currentResult.next = new ListNode(flag);
  }
  
  return result;
}
