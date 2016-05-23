/**
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/


public int missingNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 1;
    }
    
    int N = nums.length;
    int sum = N*(N + 1) / 2;
    
    for (int i = 0; i < N; i++) {
        sum -= nums[i];
    }
    
    return sum;
}
