package p3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

  LongestSubstringWithoutRepeatingCharacters target = new LongestSubstringWithoutRepeatingCharacters();

  @Test(dataProvider = "default")
  public void testLengthOfLongestSubstring(String s, int exp) {
    int act = target.lengthOfLongestSubstring(s);
    Assert.assertEquals(act, exp);
  }

  @Test(dataProvider = "default")
  public void testLengthOfLongestSubstring1(String s, int exp) {
    int act = target.lengthOfLongestSubstring1(s);
    Assert.assertEquals(act, exp);
  }

  @Test(dataProvider = "default")
  public void testLengthOfLongestSubstring2(String s, int exp) {
    int act = target.lengthOfLongestSubstring2(s);
    Assert.assertEquals(act, exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataSet() {
    return new Object[][]{
            new Object[]{"abcabcbb", 3},
            new Object[]{"", 0},
            new Object[]{"aa", 1},
            {"pwwkew", 3},
            {"abba", 2}
    };
  }
}