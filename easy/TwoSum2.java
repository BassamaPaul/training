/**
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length == 0) {
        return new int[]{0, 0};
    }
    int n = numbers.length;
    int i = 0, j = n - 1;
    while (i < j) {
        if (target - numbers[i] == numbers[j]) {
            return new int[]{i + 1, j + 1};
        } else if (target - numbers[i] < numbers[j]) {
            j--;
        } else {
            i++;
        }
    }
    return new int[]{0, 0};
}
