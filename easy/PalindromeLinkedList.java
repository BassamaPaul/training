/*
Given a singly linked list, determine if it is a palindrome.
*/

public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    
    List<Integer> values = new ArrayList<>();
    ListNode current = head;
    
    while (current != null) {
        values.add(current.val);
        current = current.next;
    }
    
    int N = values.size();
    for (int i = 0; i < N / 2; i++) {
        int v = values.get(i);
        int m = values.get(N - i - 1);
        if (v != m) {
            return false;
        }
    }
    
    return true;
}
