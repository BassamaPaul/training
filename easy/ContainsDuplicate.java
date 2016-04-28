/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

//best solution
public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) return false;
    Arrays.sort(nums);
    int N = nums.length;
    int prev = nums[0];
    for (int i = 1; i < N; i++) {
        if (nums[i] == prev) return true;
        else prev = nums[i];
    }
    return false;
}

public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) return false;
    int N = nums.length;
    HashSet s = new HashSet();
    for (int i = 0; i < N; i++) {
        if (s.contains(nums[i])) return true;
        else s.add(nums[i]);
    }
    return false;
}
