package p10;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegularExpressionMatchingTest {
  RegularExpressionMatching t = new RegularExpressionMatching();

  @Test(dataProvider = "default")
  public void test(String text, String regexp, boolean exp) {
    assertEquals(exp, t.isMatch(text, regexp));
  }

  @DataProvider(name = "default")
  public Object[][] dataset() {
    return new Object[][]{
            {"aa", "a", false},
            {"ab", ".*", true},
            {"aab", "c*a*b", true},
            {"mississippi", "mis*is*p*.", false},
            {"ab",".*c", false},
            {"a","ab*", true},
    };
  }

}