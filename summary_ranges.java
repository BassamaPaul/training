/*
  Given a sorted integer array without duplicates, return the summary of its ranges.

  For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public List<String> summaryRanges(int[] nums) {
    List<String> rangesList = new ArrayList<>();
    
    if (nums == null || nums.length == 0) return rangesList;
    int start = 0, end = 0;
    int N = nums.length;
    
    for (int i = 1; i < N; i++) {
        if (Math.abs(nums[i] - nums[end]) > 1) {
            if (start == end) rangesList.add(Integer.toString(nums[start]));
            else rangesList.add(nums[start] + "->" + nums[end]);
            start = end = i;
        } else end++;
    }
    
    if (start == end) rangesList.add(Integer.toString(nums[start]));
    else rangesList.add(nums[start] + "->" + nums[end]);
    
    return rangesList;
}
