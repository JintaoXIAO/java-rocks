package p1;

import java.util.BitSet;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) return null;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target)
          return new int[]{i, j};
      }
    }
    return null;
  }

  // bit map
  // when all positive
  public int[] twoSum1(int[] nums, int target) {
    BitSet bs = new BitSet(Integer.MAX_VALUE);
    for (int i = 0; i < nums.length; i++) {
      bs.set(nums[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      if (bs.get(target - nums[i])) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] + nums[j] == target)
            return new int[]{i, j};
        }
      }
    }
    return null;
  }

}
