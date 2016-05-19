/**
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/    

public List<List<Integer>> threeSum(int[] nums) {
  if (nums == null || nums.length == 0) {
      return Collections.emptyList();
  }
  
  Arrays.sort(nums);
  
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> solution = null;
  HashSet<List<Integer>> uniquesSolution = new HashSet<>();
  
  int N = nums.length;
  int target = 0;
  
  for (int i = 0; i < N - 2; i++) {
      int j = i + 1;
      int k = N - 1;
      
      while (j < k) {
          int sum = nums[i] + nums[j] + nums[k];
          if (sum < target) {
              j++;
          } else if (sum > target) {
              k--;
          } else {
              solution = new ArrayList<>();
              solution.add(nums[i]);
              solution.add(nums[j]);
              solution.add(nums[k]);
              
              if (!uniquesSolution.contains(solution)) {
                  result.add(solution);
                  uniquesSolution.add(solution);
              }
              
              k--;
              j++;
          }
      }
  }
  
  return result;
}
