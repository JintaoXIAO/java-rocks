package p1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import p1.TwoSum;

public class TwoSumTest {

  TwoSum solution = new TwoSum();

  @Test(dataProvider = "default")
  public void testTwoSum(int[] nums, int target, int[] result) {
    Assert.assertEquals(solution.twoSum(nums, target), result);
  }

  @Test(dataProvider = "default")
  public void testTwoSum1(int[] nums, int target, int[] result) {
    Assert.assertEquals(solution.twoSum1(nums, target), result);
  }

  @DataProvider(name = "default")
  Object[][] testData() {
    return new Object[][]{
            // nums, target, result
            new Object[]{new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}},
            new Object[]{new int[]{2, 7, 111111111, 15}, 111111113, new int[]{0, 2}},
    };
  }
}