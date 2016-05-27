/**
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public int lengthOfLongestSubstring(String s) {
  if (s == null || s.length() == 0) {
      return 0;
  }
  
  Set uniqueChars = new HashSet();
  int N = s.length();
  int max = 0;
  int j = 1;
  
  for (int i = 0; i < N; i++) {
      if (uniqueChars.contains(s.charAt(i))) {
          max = Math.max(max, uniqueChars.size());
          i = j - 1;
          j++;
          uniqueChars.clear();
          uniqueChars.add(s.charAt(i));
      } else {
          uniqueChars.add(s.charAt(i));
      }
  }
  
  return Math.max(max, uniqueChars.size());
}
