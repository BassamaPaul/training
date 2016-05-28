/**
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

public int calculate(String s) {
  if (s == null || s.length() == 0) {
      return 0;
  }
  
  int N = s.length();
  LinkedList<Character> operator = new LinkedList<>();
  LinkedList<Integer> operand = new LinkedList<>();
  boolean operandFound = false;
  
  for (int i = 0; i < N; i++) {
      char element = s.charAt(i);
      if (element == '*' || element == '/') {
          int operand1 = operand.removeLast();
          while (s.charAt(++i) == ' ');
          int operand2 = s.charAt(i) - '0';
          while (i + 1 < N && Character.isDigit(s.charAt(i + 1))) {
              operand2 *= 10;
              operand2 += s.charAt(++i) - '0';
          }
          if (element == '*') {
              operand1 *= operand2;
          } else {
              operand1 /= operand2;
          }
          operand.add(operand1);
          operandFound = false;
      } else if (element == '+' || element == '-') {
          operator.add(element);
          operandFound = false;
      } else if (Character.isDigit(element)) {
          int value = element - '0';
          if (operandFound) {
              value += operand.removeLast() * 10;
          }
          operand.add(value);
          operandFound = true;
      }
  }
  
  while (!operator.isEmpty()) {
      int val = operand.removeFirst();
      if (operator.removeFirst() == '-') {
          val -= operand.removeFirst();
      } else {
          val += operand.removeFirst();
      }
      operand.addFirst(val);
  }
  
  return operand.pop();
}
