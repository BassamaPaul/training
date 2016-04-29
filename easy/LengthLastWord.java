/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/
public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    
    int N = s.length() - 1;
    int count = 0;
    
    for (int i = N; i >= 0; i--) {
        if (s.charAt(i) != ' ') {
            count ++;
        } else if (count > 0) {
            break;
        }
    }
    
    return count;
}
    
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
