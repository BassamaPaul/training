/**
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int N = a.size();
        ArrayList<Integer> result = new ArrayList<>(2);

        result.add(searchBegin(a, 0, N, b, true));
        result.add(searchBegin(a, 0, N, b, false));

        return result;
    }

    public int searchBegin(List<Integer> a, int start, int end, int target, boolean isBegin) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (a.get(mid) == target) {
            if (isBegin) {
                if (mid == 0 || a.get(mid - 1) != target) return mid;
                return searchBegin(a, start, mid - 1, target, isBegin);
            } else {
                int N = a.size();
                if (mid >= N - 1 || a.get(mid + 1) != target) return mid;
                return searchBegin(a, mid + 1, end, target, isBegin);
            }
        } else if (a.get(mid) < target)
            return searchBegin(a, mid + 1, end, target, isBegin);
        else
            return searchBegin(a, start, mid - 1, target, isBegin);
    }
}
