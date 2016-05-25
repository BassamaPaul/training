/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

public int[] intersect(int[] nums1, int[] nums2) {
  int N = nums1.length;
  int M = nums2.length;
  
  Arrays.sort(nums1);
  Arrays.sort(nums2);
  
  List<Integer> result = new ArrayList<>();
  int i = 0;
  int j = 0;
  
  while (i < N && j < M) {
      if (nums1[i] > nums2[j]) {
          j++;
      } else if (nums1[i] < nums2[j]) {
          i++;
      } else {
          result.add(nums1[i]);
          i++;
          j++;
      }
  }
  
  int P = result.size();
  int[] intersection = new int[P];
  for (i = 0; i < P; i++) {
      intersection[i] = result.get(i);
  }
  
  return intersection;
}
