/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    if (root.left == null && root.right == null) {
        return 1;
    }
    
    int lengthOfLeftSubtree = minDepth(root.left);
    int lengthOfRightSubtree = minDepth(root.right);
    
    if (lengthOfLeftSubtree == 0) {
        return lengthOfRightSubtree + 1;
    } else if (lengthOfRightSubtree == 0) {
        return lengthOfLeftSubtree + 1;
    } else {
        return Math.min(lengthOfLeftSubtree, lengthOfRightSubtree) + 1;
    }
}
