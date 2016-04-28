/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/

public boolean isIsomorphic(String s, String t) {
  if (s == null || t == null || s.length() != t.length())
      return false;
  
  HashMap<Character, Character> h = new HashMap<>();
  int N = s.length();
  
  for (int i = 0; i < N; i++) {
      if (h.containsKey(s.charAt(i))) {
          char c = h.get(s.charAt(i));
          if (c != t.charAt(i)) return false;
      } else {
          if (h.containsValue(t.charAt(i))) return false;
          h.put(s.charAt(i), t.charAt(i));
      }
  }
  
  return true;
}
