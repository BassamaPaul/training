/**
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
        return Collections.emptyList();
    }

    List<Integer> disappearedNumbers = new ArrayList<>();
    int size = nums.length;
    boolean appearedNumbers[] = new boolean[size];

    for (int i = 0; i < size; i++) {
        appearedNumbers[nums[i] - 1] = true;
    }

    for (int i = 0; i < size; i++) {
        if (!appearedNumbers[i]) 
            disappearedNumbers.add(i + 1);
    }

    return disappearedNumbers;
}
