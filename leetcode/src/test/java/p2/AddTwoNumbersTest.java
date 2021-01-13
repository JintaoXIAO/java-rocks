package p2;

import commons.ListNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static commons.ListNode.*;
public class AddTwoNumbersTest {

  AddTwoNumbers target = new AddTwoNumbers();

  @Test(dataProvider = "default")
  public void testAddTwoNumbers(ListNode l1, ListNode l2, ListNode r) {
    ListNode act = target.addTwoNumbers(l1, l2);
    Assert.assertTrue(ListNode.equals(act, r));
  }

  @DataProvider(name = "default")
  public Object[][] testData() {
    return new Object[][]{
            new Object[]{
                    from(2,4,3),from(5,6,4),from(7,0,8)
            }
    };
  }

}