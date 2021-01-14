package p5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;

public class LongestPalindromicStringTest {

  LongestPalindromicString t = new LongestPalindromicString();

  @Test(dataProvider = "default")
  public void testLongestPalindrome(String s, Set<String> exp) {
    String act = t.longestPalindrome(s);
    Assert.assertTrue(exp.contains(act));
  }

  @Test(dataProvider = "default")
  public void testLongestPalindrome1(String s, Set<String> exp) {
    String act = t.longestPalindrome1(s);
    Assert.assertTrue(exp.contains(act));
  }

  @DataProvider(name = "default")
  Object[][] dataset() {
    return new Object[][]{
            new Object[]{"babad", Set.of("bab", "aba")},
            new Object[]{"cbbd", Set.of("bb")},
            {"a", Set.of("a")},
            {"ac", Set.of("a", "c")},
            {"bb", Set.of("bb")},
            {"ccc", Set.of("ccc")},
    };
  }
}