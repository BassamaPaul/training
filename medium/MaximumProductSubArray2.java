class ProductSubarray {
    static int min (int x, int y) {return x < y? x : y; }
 
    static int max (int x, int y) {return x > y? x : y; }
 
    static int maxSubarrayProduct(int arr[]) {
        int n = arr.length;
        int max_ending_here = 1;
 
        int min_ending_here = 1;
 
        int max_so_far = 1;
 
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                max_ending_here = max_ending_here*arr[i];
                min_ending_here = min (min_ending_here * arr[i], 1);
            } else if (arr[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            } else {
                int temp = max_ending_here;
                max_ending_here = max (min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
 
            if (max_so_far <  max_ending_here)
                max_so_far  =  max_ending_here;
        }
        return max_so_far;
    }
