package p9;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PalindromeNumberTest {

  PalindromeNumber p = new PalindromeNumber();

  @Test(dataProvider = "default")
  public void testIsPalindrome(int x, boolean exp) {
    Assert.assertEquals(p.isPalindrome(x), exp);
  }

  @Test(dataProvider = "default")
  public void testIsPalindrome1(int x, boolean exp) {
    Assert.assertEquals(p.isPalindrome1(x), exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataset() {
    return new Object[][]{
            {121, true},
            {-121, false},
            {10,false},
            {-101, false}
    };
  }
}