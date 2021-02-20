package p20;

import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    return isValid(s.toCharArray());
  }

  boolean isValid(char[] chars) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < chars.length; i++) {
      if (isLeftBracket(chars[i]))
        s.push(chars[i]);
      else {
        if (s.isEmpty() || !match(s.pop(), chars[i])) {
          return false;
        }
      }
    }
    return s.isEmpty();
  }

  boolean isLeftBracket(char c){
    return c == '('
            || c == '{'
            || c == '[';
  }

  boolean match(char l, char r){
    return (l == '(' && r == ')')
            || (l == '[' && r == ']')
            || (l == '{' && r == '}');
  }
}
