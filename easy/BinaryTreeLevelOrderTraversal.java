/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/


public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }

    List<Integer> level = new ArrayList<>();
    LinkedList<TreeNode> current = new LinkedList<>();
    LinkedList<TreeNode> next = new LinkedList<>();
    current.add(root);

    while (!current.isEmpty()) {
        TreeNode node = current.poll();
        level.add(node.val);
        if (node.left != null) {
            next.add(node.left);
        }
        if (node.right != null) {
            next.add(node.right);
        }
        if (current.isEmpty()) {
            result.add(level);
            level = new ArrayList<>();
            current = next;
            next = new LinkedList<>();
        }
    }
    return result;
}
