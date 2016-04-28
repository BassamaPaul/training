/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length <= 1) return false;
    int N = nums.length;
    HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; i++) {
        if (h.containsKey(nums[i])) {
            int ind = h.get(nums[i]);
            if (i - ind <= k) return true;
        }
        h.put(nums[i], i);
    }
    return false;
}
