/**
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
*/

public class Solution {
	public ArrayList<String> letterCombinations(String a) {
	    ArrayList<String> result = new ArrayList<>();
	    if (a == null || a.length() == 0) 
	        return result;
	    
	    Map<Character, String> touch = load();
	    int N = a.length();
	    
	    for (int i = 0; i < N; i++) {
	        combinations(result, touch.get(a.charAt(i)));
	    }
	    
	    return result;
	}
	
	public void combinations(ArrayList<String> result, String comb) {
	    if (comb == null || comb.isEmpty())
	        return;
	    if (result.size() == 0) {
	        int M = comb.length();
	        for (int i = 0; i < M; i++)
	            result.add("" + comb.charAt(i));
	    } else {
	        ArrayList<String> newResult = new ArrayList<>();
	        int M = comb.length();
	        int K = result.size();
	        for (int j = 0; j < K; j++) 
	            for (int m = 0; m < M; m++) 
	                newResult.add(result.get(j) + comb.charAt(m));
	        
	        result.clear();
	        K = newResult.size();
	        for (int j = 0; j < K; j++)
	            result.add(newResult.get(j));
	    }
	}
	
	public static Map<Character, String> load() {
	    Map<Character, String> touch = new HashMap<>();
	    touch.put('0', "0");
	    touch.put('1', "1");
	    touch.put('2', "abc");
	    touch.put('3', "def");
	    touch.put('4', "ghi");
	    touch.put('5', "jkl");
	    touch.put('6', "mno");
	    touch.put('7', "pqrs");
	    touch.put('8', "tuv");
	    touch.put('9', "wxyz");
	    return touch;
	}
}
