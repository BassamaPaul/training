/**
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
*/

//solution 1
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(result, root);
    return result;
}

private void inorder(List<Integer> result, TreeNode root) {
    if (root == null) {
        return;
    }
    
    inorder(result, root.left);
    result.add(root.val);
    inorder(result, root.right);
}

//solution 2

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> pile = new Stack<>();
    TreeNode current = root;
    
    while (!pile.empty() || current != null) {
        if (current != null) {
            pile.push(current);
            current = current.left;
        } else {
            current = pile.pop();
            result.add(current.val);
            current = current.right;
        }
    }
    
    return result;
}
