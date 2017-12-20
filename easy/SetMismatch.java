/**
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
*/

public int[] findErrorNums(int[] nums) {
    if (nums == null || nums.length == 0) {
        return new int[]{};
    }

    int n = nums.length;
    int realSum = ((n + 1)*n)/2;
    int duplicate = -1;
    int sum = 0;
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
        if (set.contains(nums[i])) {
            duplicate = nums[i];
        } else {
            set.add(nums[i]);
        }
        sum += nums[i];
    }
    return new int[]{duplicate, realSum - sum + duplicate};
}
