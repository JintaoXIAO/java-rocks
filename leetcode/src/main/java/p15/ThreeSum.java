package p15;

import java.util.*;

public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum s = new ThreeSum();
    List<List<Integer>> r = s.threeSum(new int[]{-1, -1, 0, 1, 2, -1, -4});
    System.out.println(r);
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 3) return result;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (cur > 0) return result;
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        int tmp = cur + nums[l] + nums[r];
        if (tmp == 0) {
          result.add(List.of(cur, nums[l], nums[r]));

          while (l < r && nums[l] == nums[l + 1]) l++;
          while (l < r && nums[r] == nums[r - 1]) r--;

          l++;
          r--;

        } else if (tmp < 0) {
          l++;
        } else {
          r--;
        }
      }
    }
    return result;
  }
}