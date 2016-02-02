/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) return 0;
    int N = nums.length;
    int M = N, index = 0, temp;
    boolean remove = false;
    for (int i = 0; i < N; i++) {
        if (nums[i] == val) {
            if (nums[index] != val) index = i;
            M--;
        } else {
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            index++;
        }
    }
    return M;
}
