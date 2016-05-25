/**
Given an array of integers, every element appears twice except for one. Find that single one.
*/

//solution 1
public int singleNumber(int[] nums) {
    int N = nums.length;
    Set<Integer> s = new HashSet<>();
    
    for (int i = 0; i < N; i++) {
        if (!s.add(nums[i])) {
            s.remove(nums[i]);
        }
    }
    
    return s.iterator().next();
}

//solutioin 2
public int singleNumber(int[] nums) {
  int x = 0;
  for (int v : nums) {
    x ^= v;
  }
  return x;
}
