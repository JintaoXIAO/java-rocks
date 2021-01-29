package p11;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int i = 0, j = height.length - 1;
    return maxArea(height, i, j);
  }

  int maxArea(int[] height, int i, int j) {
    if (i >= j) return 0;
    int c = water(height, i, j);
    if (height[i] < height[j]) return Math.max(c, maxArea(height,i+1, j));
    else return Math.max(c, maxArea(height,i,j-1));
  }

  int water(int[] arr, int i, int j) {
    return (j - i) * Math.min(arr[i], arr[j]);
  }
}
