package p5;

public class LongestPalindromicString {

  public String longestPalindrome(String s) {
    String p = preProcess(s);
    int ml = 1;
    String r = s.substring(0, 1);
    for (int i = 1; i < p.length(); i++) {
      int j = i - 1;
      int k = i + 1;
      while (j > 0 && k < p.length() && p.charAt(j) == p.charAt(k)) {
        j--;
        k++;
      }
      j++;
      k--;
      if (k - j + 1 > ml) {
        ml = k - j + 1;
        r = p.substring(j, k + 1);
      }
    }
    return postProcess(r);
  }

  /**
   * remove all #s
   * @param r
   * @return
   */
  private String postProcess(String r) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < r.length(); i++) {
      if (r.charAt(i) != '#')
        sb.append(r.charAt(i));
    }
    return sb.toString();
  }

  /**
   * insert # between each letter
   * @param s
   * @return
   */
  private String preProcess(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append("#").append(s.charAt(i));
    }
    sb.append("#");
    return sb.toString();
  }

  public String longestPalindrome1(String s){
    String ps = preProcess(s);
    int[] mt = new int[ps.length()];
    int mr = 0, c = 0;
    int max = 0;
    int k = 0;
    for (int i = 1; i < ps.length(); i++) {
      if (i >= c + mr){
        int j = 0;
        while (i - j >= 0 && i + j < ps.length() && ps.charAt(i - j) == ps.charAt(i + j)) {
          j++;
        }
        j--;
        if (i + j > c + mr) {
          c = i;
          mr = j;
          if (mr > max){
            max = mr;
            k = c;
          }
        }
        mt[i] = j;
      } else {
        mt[i] = Math.min(mt[2 * c - i], c + mr - i);
        int j = 0;
        while (i - j >= 0 && i + j < ps.length() && ps.charAt(i - j) == ps.charAt(i + j)) {
          j++;
        }
        j--;
        mt[i] = j;
        if (i + j > c + mr) {
          c = i;
          mr = j;
          if (mr > max){
            max = mr;
            k = c;
          }
        }
      }
    }
    return s.substring((k - max) / 2, (k + max) / 2);
  }
}
