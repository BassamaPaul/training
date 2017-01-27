/**
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST 
 */ 
 
public int kthsmallest(TreeNode root, int k) {
    if (root == null) return -1;

    Stack<TreeNode> stack = new Stack<>();
    Queue<TreeNode> finalStack = new LinkedList<>();
    TreeNode node = root;

    while (!stack.isEmpty() || node != null) {
        if (node != null) {
            stack.push(node);
            node  = node.left;
        } else {
            node = stack.pop();
            finalStack.add(node);
            node = node.right;
        }
    }

    int count = 0;
    while (!finalStack.isEmpty()) {
        TreeNode n = finalStack.poll();
        count++;
        if (count == k) return n.val;
    }

    return -1;
}
