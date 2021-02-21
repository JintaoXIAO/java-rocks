package p22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratePermutation {

  public List<List<Integer>> generate(int n) {
    int[] ints = new int[n];
    List<List<Integer>> result = new ArrayList<>();
    g(ints, 0, n, result);
    return result;
  }

  private void g(int[] ints, int i, int n, List<List<Integer>> result) {
    if (i == ints.length) {
      result.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
      return;
    }

    for (int j = 1; j <= n; j++) {
      ints[i] = j;
      g(ints, i+1, n, result);
    }
  }

  public static void main(String[] args) {
    GeneratePermutation gp = new GeneratePermutation();
    List<List<Integer>> r =  gp.generate(3);
    System.out.println(r);
  }
}
