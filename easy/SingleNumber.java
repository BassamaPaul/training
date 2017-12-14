/**
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int n = nums.length;
    Set<Integer> data = new HashSet<>();
    for (int i = 0; i < n; i++) {
        if (data.contains(nums[i])) {
            data.remove(nums[i]);
        } else {
            data.add(nums[i]);
        }
    }

    for (Integer value : data) {
        return value;
    }

    return 0; 
}
