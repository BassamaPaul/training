/**
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public int reverse(int x) {
  boolean isNegative = false;
  if (x < 0) {
      isNegative = true;
      x *= -1;
  }
  int flag = 0;
  Long value = 0L;
  while (x > 0) {
      flag = x % 10;
      value = value * 10 + flag;
      x = (x - flag) / 10;
  }
  if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) 
      return 0;
  return isNegative? value.intValue()*-1 : value.intValue();
}
