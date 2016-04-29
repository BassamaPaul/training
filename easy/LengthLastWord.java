public int lengthOfLastWord(String s) {
  if (s == null || s.length() == 0) {
      return 0;
  }
  
  int N = s.length();
  int count = 0;
  int lastWordLength = 0;
  boolean foundSpace = false;
  
  for (int i = 0; i < N; i++) {
      if (s.charAt(i) == ' ') {
          if (count > 0) {
              lastWordLength = count;
              count = 0;
          }
      } else {
          count ++;
      }
  }
  
  return count > 0? count : lastWordLength;
}
