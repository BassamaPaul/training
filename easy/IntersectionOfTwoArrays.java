/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/


public int[] intersection(int[] nums1, int[] nums2) {
  int[] emptyResult = {};
  
  if (nums1 == null || nums2 == null) {
      return emptyResult;
  }
  
  int N = nums1.length;
  int M = nums2.length;
  
  Set<Integer> set = new HashSet<>();
  
  for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
          if (nums1[i] == nums2[j] && !set.contains(nums1[i])) {
              set.add(nums1[i]);
          }
      }
  }
  
  int P = set.size();
  int[] result = new int[P];
  if (P == 0) {
      return result;
  }
  
  int i = 0;
  
  for (int val : set) {
      result[i++] = val;
  }
  
  return result;
}
