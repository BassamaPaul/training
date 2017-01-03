/**
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
        return null;
    }
    if (nums.length == 1) {
        new TreeNode(nums[0]);
    }
    return convertToBST(nums, 0, nums.length - 1);
}

private TreeNode convertToBST(int[] nums, int begin, int end) {
    if (begin > end) {
        return null;
    }
    int mid = begin + ((end - begin) / 2);
    TreeNode node = new TreeNode(nums[mid]);
    node.left = convertToBST(nums, begin, mid - 1);
    node.right = convertToBST(nums, mid + 1, end);
    return node;
}
