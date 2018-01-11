/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/

public int sumOfLeftLeaves(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
        return 0;
    }

    List<Integer> leftNodes = new ArrayList<>();
    sumOfLeftLeaves(root, false, leftNodes);

    int n = leftNodes.size();
    int sum = 0;

    for (int i = 0; i < n; i++) {
        sum += leftNodes.get(i);
    }

    return sum;
}

public void sumOfLeftLeaves(TreeNode root, boolean isLeft, List<Integer> leftNodes) {
    if (root == null) {
        return;
    }
    if (root.left == null && root.right == null) {
        if (isLeft) {
            leftNodes.add(root.val);
        }
        return;
    }
    if (root.left != null) {
        sumOfLeftLeaves(root.left, true, leftNodes);
    }
    if (root.right != null) {
        sumOfLeftLeaves(root.right, false, leftNodes);
    }
}
