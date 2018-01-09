/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/



public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
        return -1;
    }

    int n = s.length();
    Set<Character> data = new HashSet<>();
    Map<Character, Integer> index = new HashMap<>();

    for (int i = 0; i < n; i++) {
        if (data.contains(s.charAt(i))) {
            index.remove(s.charAt(i));
        } else {
            data.add(s.charAt(i));
            index.put(s.charAt(i), i);
        }

    }

    int first = n;
    for (Map.Entry<Character, Integer> entry : index.entrySet()) {
        first = Math.min(entry.getValue(), first);
    }

    return first == n? -1 : first;
}
