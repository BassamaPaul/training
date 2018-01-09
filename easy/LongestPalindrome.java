/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public int longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }

    int n = s.length();
    Map<Character, Integer> data = new HashMap<>();
    for (int i = 0; i < n; i++) {
        int value = 1;
        if (data.containsKey(s.charAt(i)))
            value += data.get(s.charAt(i));
        data.put(s.charAt(i), value);
    }

    int length = 0;
    int flag = 0;
    for (Map.Entry<Character, Integer> entry : data.entrySet()) {
        length += entry.getValue() - (entry.getValue() % 2);
        if (flag == 0) flag = entry.getValue() % 2;
    }

    return length == 0? flag : length + flag;
}
