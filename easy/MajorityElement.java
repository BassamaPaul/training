/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    int N = nums.length;
    int count = 1;
    int prev = nums[0];
    if (N == 1) return prev;
    for (int i = 1; i < N; i++) {
        if (nums[i] == prev) {
            count++;
            if (count > N / 2) return nums[i];
        } else {
            prev = nums[i];
            count = 1;
        }
    }
    return 0;
}
