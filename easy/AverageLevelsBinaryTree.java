/**
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
*/


public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) {
        result.add(0.0);
        return result;
    }

    LinkedList<TreeNode> current = new LinkedList<>();
    LinkedList<TreeNode> next = new LinkedList<>();

    double currentSum = 0.0;
    int count = 0;

    current.add(root);

    while (!current.isEmpty()) {
        TreeNode node = current.pop();

        currentSum += node.val;
        count++;

        if (node.right != null) {
            next.add(node.right);
        }
        if (node.left != null) {
            next.add(node.left);
        }

        if (current.isEmpty()) {
            result.add(currentSum / count);
            currentSum = 0;
            count = 0;

            current = next;
            next = new LinkedList<>();
        }
    }

    return result;
}
