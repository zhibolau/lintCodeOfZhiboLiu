Determine whether an integer is a palindrome. Do this without extra space.



public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
      int div = 1;
      while (x / div >= 10) {
        div *= 10;
      }        
      while (x != 0) {
        int l = x / div;
        int r = x % 10;
        if (l != r) return false;
        x = (x % div) / 10;
        div /= 100;
      }
      return true;
    }
}



bool isPalindrome(int x, int &y) {
  if (x < 0) return false;
  if (x == 0) return true;
  if (isPalindrome(x/10, y) && (x%10 == y%10)) {
    y /= 10;
    return true;
  } else {
    return false;
  }
}
bool isPalindrome(int x) {
  return isPalindrome(x, x);
}


Another approach is to first reverse the number. If the number is the same as its reversed, 
then it must be a palindrome. You could reverse a number by doing the following:


int reverse(int num) {
  assert(num >= 0);   // for non-negative integers only.
  int rev = 0;
  while (num != 0) {
    rev = rev * 10 + num % 10;
    num /= 10;
  }
  return rev;
}eturn rev;
}