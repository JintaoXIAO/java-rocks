package p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class $3Sum {

  public static void main(String[] args) {
    $3Sum s = new $3Sum();
    List<List<Integer>> r = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    System.out.println(r);
  }

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) return Collections.emptyList();
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    calculate(nums, 0, nums.length - 1, result);
    return result;
  }

  void calculate(int[] nums, int l, int r, List<List<Integer>> result) {
    if (r - l < 2) return;

    if (r - l == 2 && (nums[l] + nums[l + 1] + nums[l + 2] == 0)) {
      result.add(List.of(nums[l], nums[l + 1], nums[l + 2]));
    }

    int sum;
    sum = nums[l] + nums[l + 1] + nums[r];
    if (sum > 0) calculate(nums, l, r - 1, result);
    else if (sum == 0) result.add(List.of(nums[l], nums[l+1], nums[r]));
    for (int i = r - 1; i > l; i--) {
      sum = nums[l] + nums[r] + nums[i];
      if (sum == 0) List.of(nums[l], nums[i], nums[r]);
      else if (sum>0) break;
    }

    sum = nums[l] + nums[r - 1] + nums[r];
    if (sum < 0) calculate(nums, l + 1, r, result);
    else if (sum == 0) result.add(List.of(nums[l], nums[r-1], nums[r]));
    for (int i = l + 1; i < r; i++) {
      sum = nums[l] + nums[r] + nums[i];
      if (sum == 0) List.of(nums[l], nums[i], nums[r]);
      else if (sum < 0) break;
    }
  }
}
