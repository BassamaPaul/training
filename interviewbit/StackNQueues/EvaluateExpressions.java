/**
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public int evalRPN(ArrayList<String> a) {
    if (a == null || a.size() == 0)
        return 0;
    if (a.size() == 1)
        return Integer.parseInt(a.get(0));

    int N = a.size();
    Stack<Integer> values = new Stack<>();

    for (int i = 0; i < N; i++) {
        String data = a.get(i);
        if (data.equals("+") || data.equals("-") || 
            data.equals("/") || data.equals("*")) {
                int val2 = values.pop();
                int val1 = values.pop();
                int val = 0;
                if (data.equals("+")) val = val1 + val2;
                if (data.equals("-")) val = val1 - val2;
                if (data.equals("*")) val = val1 * val2;
                if (data.equals("/")) val = val1 / val2;
                values.push(val);
          } else {
              values.push(Integer.parseInt(data));
          }
    }

    return values.pop();
}
