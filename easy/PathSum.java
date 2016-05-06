/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
public boolean hasPathSum(TreeNode root, int sum) {
  if (root == null) {
    return false;
  }
        
  LinkedList<TreeNode> queue = new LinkedList<>();
  LinkedList<Integer> values = new LinkedList<>();
  
  queue.add(root);
  values.add(root.val);
  
  while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      int currentSum = values.poll();
      
      if (node.left == null && node.right == null && currentSum == sum) {
          return true;
      }
      
      if (node.left != null) {
          queue.add(node.left);
          values.add(currentSum + node.left.val);
      }
      
      if (node.right != null) {
          queue.add(node.right);
          values.add(currentSum + node.right.val);
      }
  }
  
  return false;
}

/**
 * solution 2
 */
public boolean hasPathSum(TreeNode root, int sum) {
  if (root == null) {
      return false;
  }
  
  List<LinkedList<TreeNode>> paths = new ArrayList<>();
  LinkedList<TreeNode> onePath = new LinkedList<>();
  
  onePath.add(root);
  paths.add(onePath);
  
  boolean stop = false;
  
  while (!stop) {
      stop = true;
      for (int i = 0; i < paths.size(); i++) {
          TreeNode node = paths.get(i).getLast();
          if (node.left != null && node.right != null) {
              onePath = duplicate(paths.get(i));
              onePath.add(node.right);
              paths.add(onePath);
              
              paths.get(i).add(node.left);
          } else if (node.left != null) {
              paths.get(i).add(node.left);
          } else if (node.right != null) {
              paths.get(i).add(node.right);
          }
          
          if (node.left != null || node.right != null) {
              stop = false;
          }
      }
  }
  
  for (int i = 0; i < paths.size(); i++) {
      onePath = paths.get(i);
      int currentSum = 0;
      while (onePath.size() > 0) {
          currentSum += onePath.removeFirst().val;
      }
      if (currentSum == sum) {
          return true;
      }
  }
  
  return false;
}

private LinkedList duplicate(LinkedList<TreeNode> onePath) {
  if (onePath == null || onePath.size() == 0) {
      return null;
  }
  LinkedList<TreeNode> newPath = new LinkedList<>();
  for (int i = 0; i < onePath.size(); i++) {
      newPath.add(onePath.get(i));
  }
  return newPath;
}
