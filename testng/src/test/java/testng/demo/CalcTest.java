package testng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class CalcTest {
  Calc calc = new Calc();

  public void testAdd() {
    int r = calc.add(1,2);
    Assert.assertEquals(r, 3);
  }

}