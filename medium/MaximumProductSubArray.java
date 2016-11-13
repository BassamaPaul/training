/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    int N = nums.length;

    int[] max = new int[N];
    int[] min = new int[N];
    int result;

    max[0] = nums[0];
    min[0] = nums[0];
    result = nums[0];

    for (int i = 1; i < N; i++) {
        if (nums[i] > 0) {
            max[i] = Math.max(nums[i], max[i - 1]*nums[i]);
            min[i] = Math.min(nums[i], min[i - 1]*nums[i]);
        } else {
            max[i] = Math.max(nums[i], min[i - 1]*nums[i]);
            min[i] = Math.min(nums[i], max[i - 1]*nums[i]);
        }

        result = Math.max(result, max[i]);
    }

    return result;
}
