/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    if (root.left == null && root.right == null) {
        return 1;
    }
    
    int lengthOfLeftSubtree = maxDepth(root.left);
    int lengthOfRightSubtree = maxDepth(root.right);
    
    if (lengthOfLeftSubtree == 0) {
        return lengthOfRightSubtree + 1;
    } else if (lengthOfRightSubtree == 0) {
        return lengthOfLeftSubtree + 1;
    } else {
        return Math.max(lengthOfLeftSubtree, lengthOfRightSubtree) + 1;
    }
}
