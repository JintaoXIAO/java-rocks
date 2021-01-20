package p8;

public class StringToInteger {
  public int myAtoi(String s) {
    StringBuilder sb = new StringBuilder();
    MatchStatus ms = MatchStatus.MatchWhitespace;
    int i = 0;
    while (i < s.length() && ms != MatchStatus.Finished) {
      char c = s.charAt(i);
      switch (ms) {
        case MatchWhitespace:
          if (c != ' '){
            i --; // backward
            ms = MatchStatus.MatchSign;
          }
          break;
        case MatchSign:
          if (c == '-' || c == '+') {
            sb.append(c);
          } else {
            i --; //backward
          }
          ms = MatchStatus.MatchLeading0;
          break;
        case MatchLeading0:
          if (c != '0'){
            i --; //backward
            ms = MatchStatus.MatchDigit;
          }
          break;
        case MatchDigit:
          if (Character.isDigit(c)){
            sb.append(c);
          } else {
            ms = MatchStatus.Finished;
          }
          break;
        default:
      }
      i++;
    }
    String n = sb.toString();
    if ("-".equals(n)||"+".equals(n)){
      return 0;
    }
    return toInt(n);
  }

  int toInt(String s) {
    if (s.isEmpty()) return 0;
    boolean negative = s.charAt(0) == '-';
    long l = Long.parseLong(s.substring(0, Math.min(s.length(), 15)));
    if (l != (int) l) {
      return negative? Integer.MIN_VALUE: Integer.MAX_VALUE;
    }
    return (int) l;
  }

  enum MatchStatus{
    MatchWhitespace,
    MatchSign, // "  sasdf[-|+|3]23sdf"
    MatchDigit, //"[23324435]"
    MatchLeading0,
    Finished
  }
}
