/**
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
        return null;
    }
    if (head.next == null) {
        return new TreeNode(head.val);
    }

    List<Integer> list = new ArrayList<>();
    ListNode current = head;

    while (current != null) {
        list.add(current.val);
        current = current.next;
    }

    return convertToBST(list, 0, list.size() - 1);
}

private TreeNode convertToBST(List<Integer> list, int begin, int end) {
    if (begin > end) {
        return null;
    }
    int mid = begin + ((end - begin) / 2);
    TreeNode node = new TreeNode(list.get(mid));
    node.left = convertToBST(list, begin, mid - 1);
    node.right = convertToBST(list, mid + 1, end);
    return node;
}
