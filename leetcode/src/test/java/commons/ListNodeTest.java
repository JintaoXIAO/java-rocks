package commons;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ListNodeTest {

  @Test
  public void testFrom() {
    ListNode l1 = ListNode.from(1,2,3);
    ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3)));
    Assert.assertTrue(ListNode.equals(l1,l2));
  }

  @Test
  public void testTestEquals() {
    ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
    ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3)));

    ListNode l3 = new ListNode(1, new ListNode(3, new ListNode(2)));
    Assert.assertTrue(ListNode.equals(l1, l2));

    Assert.assertFalse(ListNode.equals(l1, l3));
  }
}