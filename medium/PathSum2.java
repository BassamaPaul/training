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
    if (root == null) {
        return Collections.emptyList();
    }
    
    List<List<Integer>> result = new ArrayList<>();
    
    pathSum(root, result, new ArrayList<>(), 0, sum);
    
    return result;
}

private void pathSum(TreeNode root, List<List<Integer>> result,
        List<Integer> path, int currentSum, int sum) {
    if (root == null) {
        return;
    }
    
    path.add(root.val);
    currentSum += root.val;
    
    if (root.left == null && root.right == null && currentSum == sum) {
        result.add(path);
        return;
    }
    pathSum(root.left, result, new ArrayList<>(path), currentSum, sum);
    pathSum(root.right, result, new ArrayList<>(path), currentSum, sum);        
}
