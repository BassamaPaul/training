/**
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> solution = new ArrayList<>();
    
    findNumbers(k, 1, n, solution, result);
    
    return result;
}

public void findNumbers(int k, int start, int sum, 
        List<Integer> solution, List<List<Integer>> result) {
    
    if (sum == 0 && solution.size() == k) {
        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(solution);
        result.add(temp);
    }
    
    for (int i = start; i <= 9; i++) {
        if (sum - i < 0) {
            break;
        }
        if (solution.size() > k) {
            break;
        }
        solution.add(i);
        findNumbers(k, i + 1, sum - i, solution, result);
        solution.remove(solution.size() - 1);
    }
}
