package p22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses1 {
  public List<String> generateParentheses(int n){
    char[] chars = new char[n * 2];
    List<String> result = new ArrayList<>();
    g(chars, 0, result);
    return result;
  }

  void g(char[] chars, int i, List<String> result) {
    if (i == chars.length) {
      if (validate(chars))
        result.add(new String(chars));
      return;
    }
    chars[i] = '(';
    g(chars, i + 1, result);
    chars[i] = ')';
    g(chars, i + 1, result);
  }

  boolean validate(char[] chars) {
    int balance = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(') balance++;
      else balance --;
      if (balance< 0) return false;
    }
    return balance == 0;
  }

  public static void main(String[] args) {
    GenerateParentheses1 g1 = new GenerateParentheses1();
    List<String> r = g1.generateParentheses(4);
    System.out.println(r);
  }
}

