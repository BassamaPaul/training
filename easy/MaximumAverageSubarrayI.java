/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
*/

public double findMaxAverage(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return 0.0;
    }

    int n = nums.length;

    double[] sum = new double[n];
    sum[0] = nums[0];
    for (int i = 1; i < n; i++) {
        sum[i] = sum[i - 1] + nums[i];
    }

    double avg = sum[k - 1] / k;
    for (int i = k; i < n; i++) {
        avg = Math.max(avg, (sum[i] - sum[i - k]) / k);
    }

    return avg;
}
