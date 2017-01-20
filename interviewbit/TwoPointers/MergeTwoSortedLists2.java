/**
Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result. 
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]
*/

public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    if (a == null && b == null || (a.size() == 0 && b.size() == 0))
        return;
    else if (a == null) a = b;
    else if (b == null) return;

    int N = a.size();
    int M = b.size();
    int i = 0;
    int j = 0;

    while (i < N && j < M) {
        if (a.get(i) >= b.get(j)) {
            a.add(i, b.get(j));
            j++;
            N++;
        }
        i++;
    }

    if (j < M) {
        for (int k = j; k < M; k++)
            a.add(b.get(k));
    }
}
