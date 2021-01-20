package p8;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringToIntegerTest {

  StringToInteger sti = new StringToInteger();

  @Test(dataProvider = "default")
  public void testMyAtoi(String s, int exp) {
    Assert.assertEquals(sti.myAtoi(s), exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataset() {
    return new Object[][]{
            {"  123", 123},
            {"-123", -123},
            {"123p", 123},
            {"0032", 32},
            {"hello", 0},
            {" ", 0},
            {"34-43",34},
            {"123342134125453454543254", Integer.MAX_VALUE},
            {"-239082345978345789978234597821345978", Integer.MIN_VALUE},
            {"words and 987", 0},
            {"+-12",0},
            {" 000000000000000000000001234",1234},
    };
  }
}