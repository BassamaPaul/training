/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/

public boolean isAnagram(String s, String t) {
    if (t == null || s == null || t.length() != s.length()) 
        return false;
    char[] s0 = s.toCharArray();
    char[] t0 = t.toCharArray();
    int N = s0.length;
    Arrays.sort(s0);
    Arrays.sort(t0);
    return new String(s0).equals(new String(t0));
}
