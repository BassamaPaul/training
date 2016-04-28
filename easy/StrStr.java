/**
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public int strStr(String haystack, String needle) {
    if (needle.length() == 0 || haystack.equals(needle)) {
        return 0;
    }
    if (haystack.length() == 0) {
        return -1;
    }
    
    int N = haystack.length();
    int M = needle.length();
    
    for (int i = 0; i < N; i++) {
        if (needle.charAt(0) == haystack.charAt(i)) {
            if (N >= i + M && haystack.substring(i, i + M).equals(needle)) {
                return i;
            }
        }        
    }
    return -1;
}
