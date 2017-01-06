/**
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/


public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    List<Integer> d1 = new ArrayList<>();
    List<Integer> d2 = new ArrayList<>();

    ListNode c1 = l1;
    ListNode c2 = l2;

    while (c1 != null) {
        d1.add(c1.val);
        c1 = c1.next;
    }

    while (c2 != null) {
        d2.add(c2.val);
        c2 = c2.next;
    }

    int N = d1.size();
    int M = d2.size();
    int i = 0;
    int j = 0;

    ListNode result = null;
    int flag = 0;

    while (i < N || j < M) {
        int val = flag;
        if (i < N) {
            val += d1.get(N - 1 - i);
            i++;
        }
        if (j < M) {
            val += d2.get(M - 1 - j);
            j++;
        }

        if (val >= 10) {
            val -= 10;
            flag = 1;
        } else {
            flag = 0;
        }

        ListNode node = new ListNode(val);
        if (result == null) {
            result = node;
        } else {
            ListNode tmp = result;
            result = node;
            result.next = tmp;
        }
    }

    if (flag > 0) {
        ListNode tmp = result;
        result = new ListNode(flag);
        result.next = tmp;
    }

    return result;
}
