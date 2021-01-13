package commons;

public class ListNode {
  public int val;
  public ListNode next;
  public ListNode() {}
  public ListNode(int val) {
    this.val = val;
  }
  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode from(int... vals) {
    assert vals != null;
    assert vals.length > 0;
    ListNode l = new ListNode();
    ListNode pl = l;
    for (int val : vals) {
      pl.next = new ListNode(val);
      pl = pl.next;
    }
    return l.next;
  }

  public static boolean equals(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return true;
    if (l1 != null && l2 != null) {
      return l1.val == l2.val && equals(l1.next, l2.next);
    }
    return false;
  }

  public static String toSting(ListNode l) {
    StringBuilder sb = new StringBuilder();
    sb.append("ListNode{ ");
    ListNode pl = l;
    while (pl != null){
      sb.append(pl.val).append(" ");
      pl = pl.next;
    }
    sb.append("}");
    return sb.toString();
  }
}
