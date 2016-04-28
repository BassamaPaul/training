/*
  Rotate an array of n elements to the right by k steps.

  For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
*/

public void rotate(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) return;
    
    int N = nums.length;
    int[] backup = new int[k];
    int j = 0, i;
    
    if (k > N) k -= N;
    
    for (i = N - k; i < N; i++) {
        backup[j++] = nums[i];
    }
    int E = N - k;
    for (i = 0; i < E; i++) {
        nums[N - 1 - i] = nums[E - 1 - i];
    }
    for (i = 0; i < k; i++) {
        nums[i] = backup[i];
    }
}
