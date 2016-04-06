/**
Given an integer, write a function to determine if it is a power of three.
*/

public boolean isPowerOfThree(int n) {
    if (n <= 0) return false;
    int flag;
    while (n > 1) {
        flag = n / 3;
        if (flag*3 != n) return false;
        n = flag;
    }
    return true;
}
