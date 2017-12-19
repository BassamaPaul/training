/**
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/


public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    binaryTreePaths(root, "", result);
    return result;
}

private void binaryTreePaths(TreeNode root, String path, List<String> result) {
    if (root == null) {
        return;
    }
    path += root.val;
    if (root.left == null && root.right == null) {
        result.add(path);
        return;
    }
    binaryTreePaths(root.left, path + "->", result);
    binaryTreePaths(root.right, path + "->", result);
}
