package p14;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs){
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

    StringBuilder sb = new StringBuilder();
    outer: for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i < strs[j].length() && c == strs[j].charAt(i)) {
          if (j == strs.length - 1)
            sb.append(c);
        } else {
          break outer;
        }
      }
    }
    return sb.toString();
  }
}
