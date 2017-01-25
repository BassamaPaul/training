/**
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a == null || a.size() == 0)
            return result;

        Collections.sort(a);
        findCombinations(result, new ArrayList<>(), 0, b, a, 0);
        return result;
    }

    public void findCombinations(ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> c, int currentSum, int target, ArrayList<Integer> a, int k) {
        if (currentSum == target)
            result.add(c);
        else if (currentSum < target) {
              int N = a.size();
              for (int i = k; i < N; i++) {
                  if (i != 0 && a.get(i) == a.get(i - 1))
                      continue;
                  if (currentSum + a.get(i) > target) 
                      continue;
                  ArrayList<Integer> cPrime = new ArrayList<>();
                  for (int j = 0; j < c.size(); j++)
                      cPrime.add(c.get(j));
                  cPrime.add(a.get(i));
                  findCombinations(result, cPrime, currentSum + a.get(i), target, a, i);
              }
        }
    }
}
