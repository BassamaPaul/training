/**
Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    }     
}
*/

public ArrayList<String> prettyJSON(String a) {
    ArrayList<String> result = new ArrayList<>();
    if (a == null || a.length() == 0)
        return result;

    int N = a.length();
    int countTab = 0;
    StringBuilder currentLine = new StringBuilder();

    for (int i = 0; i < N; i++) {
        char c = a.charAt(i);
        if (c == '[' || c == '{' || c == ']' || c == '}') {
            if (currentLine.length() > 0 && 
                currentLine.charAt(currentLine.length() - 1) != '\t') 
                result.add(currentLine.toString());
            currentLine = new StringBuilder();

            int k = 0;
            int remove = 0;

            if (c == '[' || c == '{') {
                countTab++;
                remove = 1;
            } else countTab--;

            k = 0;
            while (k < countTab - remove) {
                currentLine.append("\t");
                k++;
            }

            currentLine.append(c);
            if (i < N - 1 && a.charAt(i + 1) == ',') {
                currentLine.append(a.charAt(i + 1));
                i++;
            }
            result.add(currentLine.toString());

            currentLine = new StringBuilder();

            k = 0;
            while (k < countTab) {
                currentLine.append("\t");
                k++;
            }

        } else if (c == ',') {
            currentLine.append(c);
            result.add(currentLine.toString());
            currentLine = new StringBuilder();

            int k = 0;
            while (k < countTab) {
                currentLine.append("\t");
                k++;
            }
        } else {
            currentLine.append(c);
        }
    }

    return result;
}
