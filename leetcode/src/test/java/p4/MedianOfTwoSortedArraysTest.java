package p4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MedianOfTwoSortedArraysTest {

  MedianOfTwoSortedArrays t = new MedianOfTwoSortedArrays();

  @Test(dataProvider = "default")
  public void testFindMedianSortedArrays(int[] nums1, int[] nums2, double exp) {
    double act = t.findMedianSortedArrays(nums1, nums2);
    Assert.assertEquals(act, exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataSet() {
    return new Object[][]{
            {new int[]{1,3,4}, new int[]{2}, 2.5}
    };
  }
}