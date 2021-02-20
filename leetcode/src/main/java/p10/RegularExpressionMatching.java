package p10;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p){
    return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
  }

  boolean isMatch(char[] text, int i, char[] regexp, int j){
    if (i == text.length && j == regexp.length) return true;
    if (j == regexp.length) return false;
    if (j < regexp.length - 1 && regexp[j + 1] == '*') {
      return matchStar(text, i, regexp[j], regexp, j + 2);
    }

    return (i < text.length
            && (text[i] == regexp[j] || regexp[j] == '.')) && isMatch(text, i + 1, regexp, j + 1);
  }

  boolean matchStar(char[] text, int i, char c, char[] regexp, int j) {
    do {
      if (isMatch(text, i, regexp, j))
        return true;

    } while (i < text.length && (text[i++] == c || c == '.'));
    return false;
  }
}
