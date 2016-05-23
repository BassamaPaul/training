/**Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return -1;
    }
    
    int N = nums.length;
    
    for (int i = 0; i < N; i++) {
        if (nums[i] >= target) {
            return i;
        }
        
        if (i < N - 1 && (nums[i] < target && nums[i + 1] > target)) {
            return i + 1;
        }
    }
    
    return N;
}
