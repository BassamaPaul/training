public List<Integer> getRow(int rowIndex) {
    List<Integer> current = new ArrayList<>();
    current.add(1);
    
    if (rowIndex <= 0) return current;
    
    List<Integer> previous = current;
    
    for (int i = 1; i <= rowIndex; i++) {
        current = new ArrayList<>();
        current.add(1);
        
        for (int j = 0; j < i - 1; j++) {
            current.add(j + 1, previous.get(j) + previous.get(j + 1));
        }
        
        current.add(1);
        previous = current;
    }
    return current;
}
