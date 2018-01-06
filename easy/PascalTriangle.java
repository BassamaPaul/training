/*
  Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = new ArrayList<>();
    
    if (numRows <= 0) return list;
    
    List<Integer> previous, current;
    
    current = new ArrayList<>();
    current.add(1);
    list.add(current);
    previous = current;
    
    for (int i = 1; i < numRows; i++) {
        current = new ArrayList<>();
        current.add(1);
        
        for (int j = 0; j < i - 1; j++) {
            current.add(previous.get(j) + previous.get(j + 1));
        }
        
        current.add(1);
        list.add(current);
        previous = current;
    }
    return list;
}

// Generate
public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) {
        return Collections.emptyList();
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> previous = new ArrayList<>();
    previous.add(1);
    result.add(previous);

    for (int i = 1; i < numRows; i++) {
        List<Integer> last = new ArrayList<>();
        int m = previous.size();
        last.add(1);
        for (int j = 1; j < m; j++) {
            last.add(previous.get(j - 1) + previous.get(j));
        }
        last.add(1);
        result.add(last);
        previous = last;
    }

    return result;
}
