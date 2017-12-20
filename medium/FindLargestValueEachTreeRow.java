/**
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    LinkedList<TreeNode> next = new LinkedList<>();
    int currentMax = Integer.MIN_VALUE;

    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        currentMax = Math.max(currentMax, node.val);
        if (node.left != null) {
            next.add(node.left);
        }
        if (node.right != null) {
            next.add(node.right);
        }
        if (queue.isEmpty()) {
            queue = next;
            next = new LinkedList<>();
            result.add(currentMax);
            currentMax = Integer.MIN_VALUE;
        }
    }

    return result;
}
