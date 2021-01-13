package p4;

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int l1 = nums1.length, l2 = nums2.length;
    int k1 = (l1 + l2 + 1) / 2;
    int k2 = (l1 + l2 + 2) / 2;

    return (getKth(nums1, 0, nums2, 0, k1) + getKth(nums1, 0, nums2, 0, k2)) / 2.0;

  }

  int getKth(int[] nums1, int i, int[] nums2, int j, int k) {
    if (i >= nums1.length) return nums2[j + k - 1];
    if (j >= nums2.length) return nums1[i + k - 1];

    if (k == 1) {
      return Math.min(nums1[i],nums2[j]);
    }

    int m1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
    int m2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

    if (m1 < m2) {
      return getKth(nums1, i + k / 2, nums2, j, k - k / 2);
    } else {
      return getKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
  }

  public static void main(String[] args) {
    MedianOfTwoSortedArrays t = new MedianOfTwoSortedArrays();
    double a = t.findMedianSortedArrays(new int[]{1,3,4}, new int[]{2});
    System.out.println(a);
  }
}
