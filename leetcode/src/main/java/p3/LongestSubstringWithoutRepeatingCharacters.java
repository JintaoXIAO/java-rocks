package p3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int l = 0, r = 0;
    int maxLength = 0;
    while (r < s.length()) {
      for (int i = l; i < r;  i++) {
        if (s.charAt(i) == s.charAt(r))
          l = i + 1;
      }
      int tmp = r - l + 1;
      if (tmp > maxLength) {
        maxLength = tmp;
      }
      r++;
    }
    return maxLength;
  }

  public int lengthOfLongestSubstring1(String s) {
    Map<Character, Integer> indexMap = new HashMap<>();
    int maxLength = 0;
    int l = 0, r = 0;
    while (r < s.length()) {
      char c = s.charAt(r);
      int pci = indexMap.getOrDefault(c,-1);
      l = Math.max(l, pci + 1);
      maxLength = Math.max(maxLength, r - l + 1);
      indexMap.put(c, r);
      r++;
    }
    return maxLength;
  }

  public int lengthOfLongestSubstring2(String s) {
    int[] indexMap = new int[128]; // 128 for letter space numbers
    Arrays.fill(indexMap, -1);
    int maxLength = 0;
    int l = 0, r = 0;
    while (r < s.length()) {
      char c = s.charAt(r);
      int pci = indexMap[c];
      l = Math.max(pci + 1, l);
      maxLength = Math.max(r - l + 1, maxLength);
      indexMap[c] = r;
      r ++;
    }
    return maxLength;
  }
}
