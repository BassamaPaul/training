/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    pathSum(root, sum, 0, new ArrayList<>(), result);
    return result;
}

private void pathSum(TreeNode node, int sum, int currentSum, 
                     List<Integer> currentPath, List<List<Integer>> result) {
    if (node == null) {
        return;
    }
    if (node.left == null && node.right == null) {
        if (currentSum + node.val == sum) {
            currentPath.add(node.val);
            result.add(currentPath);
        }
        return;
    }
    List<Integer> path1 = new ArrayList<>(currentPath);
    path1.add(node.val);
    pathSum(node.left, sum, currentSum + node.val, path1, result);

    List<Integer> path2 = new ArrayList<>(currentPath);    
    path2.add(node.val);
    pathSum(node.right, sum, currentSum + node.val, path2, result);
}
