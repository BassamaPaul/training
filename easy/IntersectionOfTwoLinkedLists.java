/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    
    ListNode currentA = headA;
    ListNode currentB = headB;
    int n1 = 0;
    int n2 = 0;
    
    while (currentA != null) {
        n1++;
        currentA = currentA.next;
    }
    
    while (currentB != null) {
        n2++;
        currentB = currentB.next;
    }
    
    currentA = headA;
    currentB = headB;
    
    if (n1 > n2) {
        while (n2 < n1) {
            currentA = currentA.next;
            n1--;
        }
    } else {
        if (n1 < n2) 
            while (n2 > n1) {
                currentB = currentB.next;
                n2--;
            }
    }
    
    while (currentA != null && currentB != null) {
        if (currentA == currentB) return currentA;
        currentA = currentA.next;
        currentB = currentB.next;
    }
    
    return null;
}


//new solution 20/12/2019
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
        return null;
    }
    ListNode current = headA;
    Set<ListNode> set = new HashSet<>();
    while (current != null) {
        set.add(current);
        current = current.next;
    }

    current = headB;
    while (current != null) {
        if (set.contains(current)) {
            return current;
        }
        current = current.next;
    }

    return null;
}
