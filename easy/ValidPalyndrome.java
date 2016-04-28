/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

public boolean isPalindrome(String s) {
    if (s == null) {
        return true;
    }
    
    s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
    
    int N = s.length();
    int i = 0;
    int j = N - 1;
    
    while (i < j) {
        if (s.charAt(i++) != s.charAt(j--)) {
            return false;
        }
    }
    return true;
}
