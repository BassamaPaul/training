/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
        return null;
    }

    RandomListNode newHead = new RandomListNode(head.label);
    RandomListNode currentNewHead = newHead;
    RandomListNode current = head;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();

    map.put(current, currentNewHead);

    while (current.next != null) {
        current = current.next;
        currentNewHead.next = new RandomListNode(current.label);
        currentNewHead = currentNewHead.next;
        map.put(current, currentNewHead);
    }

    current = head;
    currentNewHead = newHead;

    while (current != null) {
        if (current.random == null) {
            currentNewHead.random = null;
        } else {
            currentNewHead.random = map.get(current.random);    
        }
        current = current.next;
        currentNewHead = currentNewHead.next;
    }

    return newHead;
}
