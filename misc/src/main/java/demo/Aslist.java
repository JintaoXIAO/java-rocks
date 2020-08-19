package demo;

import java.util.Arrays;
import java.util.List;

public class Aslist {
  public static void main(String[] args) {
    List<Season> list =  Arrays.asList(Season.SPRING, Season.FALL);
    System.out.println(list);
  }
  enum Season {
    SPRING,SUMMER, FALL,WINTER
  }
}
