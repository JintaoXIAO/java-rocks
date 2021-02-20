package p22;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses {
  public List<String> generateParenthesis(int n){
    List<String> initial = List.of("(",")");
    for (int i = 0; i < 2 * n - 1; i++) {
      initial = expand(initial);
    }
    return initial.stream().filter(this::isValid).collect(Collectors.toList());
  }
  
  List<String> expand(List<String> list){
    return list.stream().flatMap(s -> List.of(s + "(", s + ")").stream())
            .collect(Collectors.toList());
  }

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
    return c == '(';
  }

  boolean match(char l, char r){
    return (l == '(' && r == ')');
  }

}
