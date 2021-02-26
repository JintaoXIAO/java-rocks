package p16;

import java.util.Arrays;

public class ThreeSumCloset {
  public static void main(String[] args) {
    ThreeSumCloset t = new ThreeSumCloset();
    int[] a = {0,2,1,-3};
    int r = t.threeSumClosest(a, 1);
    System.out.println(r);
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int best = 10_000;

    for (int i = 0; i < nums.length; i++) {

      if (i>0 && nums[i] == nums[i-1]) continue;

      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum - target == 0) return sum;
        if (Math.abs(sum - target) < Math.abs(best - target)){
          best = sum;
        }
        if (sum > target) {
          r--;
          while (r > l && nums[r] == nums[r + 1]) r--;

        } else {
          l++;
          while (l<r && nums[l] == nums[l-1]) l++;
        }
      }
    }
    return best;
  }
}

