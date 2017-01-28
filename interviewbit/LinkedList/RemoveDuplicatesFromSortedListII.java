public ListNode deleteDuplicates(ListNode a) {
    if (a == null || a.next == null) {
        return a;
    }

    ListNode current = a;
    boolean removeHead = false;
    if (current.val == current.next.val) {
        removeHead = true;
        while (current != null && current.next != null 
            && current.val == current.next.val)
            current.next = current.next.next;
        if (current.next == null) return null;
    }

    ListNode prev = current;
    current = current.next;

    if (current.next == null) {
        if (removeHead) return prev.next;
        else return prev;
    }

    while (current != null && current.next != null) {

        if (current != null && current.next != null 
            && current.val == current.next.val) {

            while (current != null && current.next != null 
                && current.val == current.next.val) {
                ListNode next = current.next;     
                current.next = current.next.next;
                next.next = null;
            }

            prev.next = current.next;
            current.next = null;

            current = prev.next;
        } else {
            prev = current;
            current = current.next;
        }
    }

    if (removeHead && a != null) return a.next;
    return a;
}
