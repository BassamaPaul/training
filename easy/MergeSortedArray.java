/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || (m == 0 && n == 0) || nums2 == null) 
        return;
    int i = m - 1, j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (nums1[i] >= nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }
    if (j >= 0) {
        for (i = 0; i <= j; i++) nums1[i] = nums2[i];
    }
}

//solution 30/01/2018
public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (m == 0 && n == 0) {
        return;
    }

    int i = 0;
    int s1 = nums1.length;
    while (m < s1) {
        int k = m;
        nums1[k] = nums2[i++];
        while (k > 0 && nums1[k] < nums1[k - 1]) {
            int temp = nums[k];
            nums[k] = nums[k-1];
            nums[k-1] = temp;
            k--;
        }
        m++;
    }
}
