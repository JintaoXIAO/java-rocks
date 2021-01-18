package p7;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReverseIntegerTest {

  ReverseInteger ri = new ReverseInteger();

  @Test(dataProvider = "default")
  public void testReverse(int x, int exp) {
    Assert.assertEquals(ri.reverse(x), exp);
  }

  @Test(dataProvider = "default")
  public void testReverse1(int x, int exp) {
    Assert.assertEquals(ri.reverse1(x), exp);
  }

  @DataProvider(name = "default")
  Object[][] dataset() {
    return new Object[][]{
            {123, 321},
            {-123,-321},
            {120,21},
            {1534236469, 0}
    };
  }
}