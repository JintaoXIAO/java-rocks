package p2;

import commons.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode r = new ListNode();
    ListNode pr = r;
    while (l1 != null || l2 != null || carry != 0) {
      int tmp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
      carry = tmp / 10;
      pr.next = new ListNode(tmp % 10);

      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;
      pr = pr.next;
    }
    return r.next;
  }
}
