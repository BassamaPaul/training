/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public boolean isValid(String s) {
  if (s == null) {
      return true;
  }
  
  Stack<Character> parenthesis = new Stack<>();
  
  int N = s.length();
  
  for (int i = 0; i < N; i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
          parenthesis.push(s.charAt(i));
      } else {
          if (parenthesis.isEmpty()) {
              return false;
          }
          if ((s.charAt(i) == ')' && parenthesis.peek() == '(') ||
              (s.charAt(i) == ']' && parenthesis.peek() == '[') ||
              (s.charAt(i) == '}' && parenthesis.peek() == '{')) {
              parenthesis.pop();
          } else {
              return false;
          }
      }
  }
  return parenthesis.isEmpty();
}

/* new solution at 14 december 2017 */
public boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
        return true;
    }
    int n = s.length();
    Stack<Character> stack = new Stack<>();
    Character c;
    for (int i = 0; i < n; i++) {
        if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
            stack.push(s.charAt(i));
            if (stack.size() > n - i - 1) {
                return false;
            }
        } else if (stack.isEmpty() || ((c = stack.pop()) != null && 
                (c == '(' && s.charAt(i) != ')' || 
                c == '{' && s.charAt(i) != '}' || 
                c == '[' && s.charAt(i) != ']'))) {
            return false;
        }
    }
    return stack.isEmpty();
}
