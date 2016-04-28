/**
Given an integer, write a function to determine if it is a power of two.
*/

public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    int flag;
    while (n > 1) {
        flag = n / 2;
        if (flag*2 != n) return false;
        n = flag;
    }
    return true;
}
