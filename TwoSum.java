/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    int N = nums.length;
    int numberToSearch;
    for (int i = 0; i < N; i++) {
        numberToSearch = target - nums[i];
        if (numsMap.containsKey(numberToSearch)) {
            int j = numsMap.get(numberToSearch);
            return new int[]{j, i};
        }
        numsMap.put(nums[i], i);
    }
    return null;
}
