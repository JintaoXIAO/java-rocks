package p20;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidParenthesesTest {
  ValidParentheses v = new ValidParentheses();
  @Test(dataProvider = "default")
  public void test(String s, boolean exp){
    assertEquals(v.isValid(s), exp);
  }

  @DataProvider(name = "default")
  public Object[][] dataset() {
    return new Object[][]{
            {"{}", true},
            {"()[]{}",true},
    };
  }


}