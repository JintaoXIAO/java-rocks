package p9;

import java.util.ArrayList;
import java.util.List;

/**
 * solve it without converting the integer to a string
 */
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    List<Integer> digits = new ArrayList<>();
    while (x != 0){
      digits.add(x % 10);
      x = x / 10;
    }

    int i = 0, j = digits.size() - 1;
    while (i < j) {
      if (!digits.get(i).equals(digits.get(j))) return false;
      i++;
      j--;
    }
    return true;
  }

  public boolean isPalindrome1(int x) {
    if (x < 0) return false;
    int x1 = x;
    int r = 0;
    do {
      r = r * 10 + (x1 % 10);

      x1 = x1 / 10;
    } while (x1 != 0);

    return r == x;
  }
}
