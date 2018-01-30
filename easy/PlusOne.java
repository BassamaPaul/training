/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) return digits;
    int N = digits.length, left = 1;
    for (int i = N - 1; i >= 0; i--) {
        digits[i] = digits[i] + left;
        left = 0;
        if (digits[i] > 9) {
            left = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
    }
    
    if (left == 0) return digits;
    
    int[] digits2 = new int[N + 1];
    
    for (int i = 0; i < N; i++) {
        digits2[i + 1] = digits[i];
    }
    digits2[0] = left;
    return digits2;
}

//
public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) {
        return digits;
    }

    int n = digits.length;
    int flag = 1;

    for (int i = n - 1; i >= 0; i--) {
        digits[i] = digits[i] + flag;
        flag = 0;
        if (digits[i] == 10) {
            flag = 1;
        }
        digits[i] = digits[i] % 10;
    }

    if (flag == 1) {
        int m = n + 1;
        int[] temp = new int[m];
        temp[0] = 1;
        for (int i = 1; i < m; i++) {
            temp[i] = digits[i - 1];
        }
        digits = temp;
    }

    return digits;
}
