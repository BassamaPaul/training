/**
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/    
    
public List<List<Integer>> fourSum(int[] nums, int target) {
  int numberOfSolutions = 4;
  
  if (nums == null || nums.length < numberOfSolutions) {
      return Collections.emptyList();
  }
  
  Arrays.sort(nums);
  
  HashSet<List<Integer>> uniquesSolutions = new HashSet<>();
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> solution = null;
  
  int N = nums.length;
  
  for (int i = 0; i < N - 3; i++) {
      for (int j = i + 1; j < N - 2; j++) {
          int k = j + 1;
          int l = N - 1;
          
          while (k < l) {
              int sum = nums[i] + nums[j] + nums[k] + nums[l];
              
              if (sum < target) {
                  k++;
              } else if (sum > target) {
                  l--;
              } else {
                  solution = new ArrayList<>();
                  solution.add(nums[i]);
                  solution.add(nums[j]);
                  solution.add(nums[k]);
                  solution.add(nums[l]);
                  
                  if (!uniquesSolutions.contains(solution)) {
                      result.add(solution);
                      uniquesSolutions.add(solution);
                  }
                  
                  k++;
                  l--;
              }
          }
      }
  }
  
  return result;
}
