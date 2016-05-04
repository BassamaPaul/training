/**
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

public List<List<Integer>> levelOrderBottom(TreeNode root) {
  if (root == null) {
      return new LinkedList<>();
  }
  
  LinkedList<TreeNode> queue = new LinkedList<>();
  LinkedList<TreeNode> queueTemp = new LinkedList<>();
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> oneRow = new ArrayList<>();
  
  queue.add(root);
  
  while (queue.size() > 0) {
      TreeNode node = queue.removeFirst();
      oneRow.add(node.val);
      
      if (node.left != null) {
          queueTemp.add(node.left);    
      }
      if (node.right != null) {
          queueTemp.add(node.right);
      }
      
      if (queue.size() == 0) {
          queue = queueTemp;
          queueTemp = new LinkedList<>();
          result.add(oneRow);
          oneRow = new ArrayList<>();
      }
  }
  
  List<List<Integer>> reversedResult = new ArrayList<>();
  int N = result.size();
  for (int i = N - 1; i >= 0; i--) {
      reversedResult.add(result.get(i));
  }
  
  return reversedResult;
}
