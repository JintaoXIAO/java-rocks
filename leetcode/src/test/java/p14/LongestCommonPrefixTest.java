package p14;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LongestCommonPrefixTest {
  LongestCommonPrefix t = new LongestCommonPrefix();
  @Test(dataProvider = "default")
  public void test(String[] strs, String exp){
    assertEquals(t.longestCommonPrefix(strs), exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataset() {
    return new Object[][]{
            {new String[]{"flower", "flow", "flight"}, "fl"},
            {new String[]{"dog", "racecar", "car"}, ""},
            {new String[]{"hello","","hell"},""},
            {new String[]{"cir","car"}, "c"},
    };
  }

}