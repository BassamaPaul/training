/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
*/

public ListNode detectCycle(ListNode a) {
    if (a == null || a.next == null)
        return a;

    HashSet<ListNode> set = new HashSet<>();

    ListNode current = a;
    while (current != null) {
        if (set.contains(current))
            return current;
        else {
            set.add(current);
        }
        current = current.next;
    }

    return null;
}
