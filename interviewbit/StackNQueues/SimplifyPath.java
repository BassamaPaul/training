/**
Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.
*/

public String simplifyPath(String a) {
    if (a == null || a.length() == 0)
        return a;
    int N = a.length();
    Stack<Character> simplePath = new Stack<>();

    for (int i = 0; i < N; i++) {
        char c = a.charAt(i);
        if (c == '.') {
            if (i < N - 1 && a.charAt(i + 1) == '.') {
                if (simplePath.isEmpty() || simplePath.size() == 1) continue;
                if (simplePath.peek() == '/') simplePath.pop();
                while (!simplePath.isEmpty() && simplePath.peek() != '/') 
                    simplePath.pop();
                i++;
            }
        } else if ((c == '/' && 
            (simplePath.isEmpty() || simplePath.peek() != '/')) || c != '/') {
            simplePath.push(c);              
          }
    }

    if (simplePath.isEmpty())
        return "/";

    StringBuilder newPath = new StringBuilder();
    if (simplePath.size() > 1 && simplePath.peek() == '/')
        simplePath.pop();
    while (!simplePath.isEmpty()) 
        newPath.append(simplePath.pop());

    return newPath.reverse().toString();
}
