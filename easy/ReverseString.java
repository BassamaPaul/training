/**
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/
public String reverseString(String s) {
    if (s == null) {
        return null;
    }
    
    int N = s.length();
    int i = 0;
    int j = N - 1;
    char c;
    
    char[] sArray = s.toCharArray();
    
    while (i < j) {
        c = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = c;
        i++;
        j--;
    }
    
    return new String(sArray);
}
