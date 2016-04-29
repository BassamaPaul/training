/**
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public String addBinary(String a, String b) {
  if (a == null && b == null) {
      return null;
  } if (a == null) {
      return b;
  } else if (b == null) {
      return a;
  }
  
  int N = a.length() - 1;
  int M = b.length() - 1;
  int flag = 0;
  String result = "";
  
  while (N >= 0 || M >= 0) {
      int sum = flag;
      if (N >= 0) {
          sum += (a.charAt(N) - '0');
          N--;
      }
      if (M >= 0) {
          sum += (b.charAt(M) - '0');
          M--;
      }
      if (sum == 3) {
          result = '1' + result;
          flag = 1;
      } else if (sum == 2) {
          result = '0' + result;
          flag = 1;
      } else if (sum == 1) {
          result = '1' + result;
          flag = 0;
      } else {
          result = '0' + result;
          flag = 0;
      }
  }
  return flag == 1? flag + result : result;
}
