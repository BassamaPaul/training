/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
//solution 1
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

//solution 2

public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    LinkedList<TreeNode> queue = new LinkedList<>();
    LinkedList<Integer> counts = new LinkedList<>();
    
    queue.add(root);
    counts.add(1);
    
    while (queue.size() > 0) {
        TreeNode currentNode = queue.pop();
        int count = counts.pop();
        
        if (currentNode.left == null && currentNode.right == null) {
            return count;
        }
        
        if (currentNode.left != null) {
            queue.add(currentNode.left);
            counts.add(count + 1);
        }
        
        if (currentNode.right != null) {
            queue.add(currentNode.right);
            counts.add(count + 1);
        }
    }
    
    return 0;
}

/** other solution 20/12/2017 */
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    if (root.left == null && root.right == null) {
        return 1;
    } else if (root.left != null && root.right != null) {
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    } else if (root.left != null) {
        return 1 + minDepth(root.left);
    } else {
        return 1 + minDepth(root.right);
    }
}
