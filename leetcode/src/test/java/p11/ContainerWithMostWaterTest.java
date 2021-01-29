package p11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContainerWithMostWaterTest {

  ContainerWithMostWater cww = new ContainerWithMostWater();

  @Test(dataProvider = "default")
  public void testMaxArea(int[] height, int exp) {
    int act = cww.maxArea(height);
    Assert.assertEquals(act, exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataset() {
    return new Object[][]{
            {new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
            {new int[]{1,1}, 1},
            {new int[]{4,3,2,1,4}, 16},
            {new int[]{1,2,1},2},
    };
  }
}