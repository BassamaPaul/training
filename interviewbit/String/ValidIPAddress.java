/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
*/

public ArrayList<String> restoreIpAddresses(String a) {
    ArrayList<String> result = new ArrayList<>();
    if (a == null || a.length() == 0 || a.length() > 12)
        return result;
    int N = a.length();
    validIP(result, "", a, 1);
    return result;
}

public void validIP(ArrayList<String> result, String firstPart, String rest, int block) {
    if (block == 4) {
        if (rest.isEmpty()) 
            return;
        int part = Integer.parseInt(rest);
        if (rest.length() == 3 && part > 255) 
            return;
        else if (rest.length() == 1 || (rest.length() > 1 && rest.charAt(0) != '0')) 
            result.add(firstPart + "." + rest);
    } else {
        if (!firstPart.isEmpty()) firstPart += ".";
        int countMaxRestantBlockNumber = (4 - block) * 3;
        block++;

        if (rest.length() > 1 && rest.length() - 1 <= countMaxRestantBlockNumber) 
            validIP(result, 
            firstPart + rest.substring(0, 1), rest.substring(1), block);

        if (rest.length() > 2 && rest.charAt(0) != '0') {
            if (rest.length() - 2 <= countMaxRestantBlockNumber) 
                validIP(result, firstPart + rest.substring(0, 2), rest.substring(2), block);
        }

        if (rest.length() > 3 && rest.charAt(0) != '0') {
            int part = Integer.parseInt(rest.substring(0, 3));     
            if (rest.length() - 3 <= countMaxRestantBlockNumber && part <= 255) 
                validIP(result, firstPart + rest.substring(0, 3), rest.substring(3), block);
        }
    }
}
