/**
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/

public boolean isSameTree(TreeNode p, TreeNode q) {
  if (p == null && q == null) {
      return true;
  } else if (p != null && q != null) {
      if (p.val == q.val) {
          return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      } else {
          return false;
      }
  } else {
      return false;
  }
}

// other solution 19/12/2017

public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == q) {
        return true;
    }

    if (p == null || q == null) {
        return false;
    }

    Stack<TreeNode> pStack = new Stack<>();
    Stack<TreeNode> qStack = new Stack<>();
    pStack.push(p);
    qStack.push(q);

    while (!pStack.isEmpty() && !qStack.isEmpty()) {
        TreeNode pNode = pStack.pop();
        TreeNode qNode = qStack.pop();
        if (pNode == null && qNode == null) {
            continue;
        } else if ((pNode == null || qNode == null) || (pNode.val != qNode.val)) {
            return false;
        }
        pStack.push(pNode.right);
        pStack.push(pNode.left);

        qStack.push(qNode.right);
        qStack.push(qNode.left);
    }

    return pStack.isEmpty() && qStack.isEmpty();
}
