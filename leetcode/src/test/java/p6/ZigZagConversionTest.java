package p6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZigZagConversionTest {

  @Test(dataProvider = "default")
  public void testConvert(String s, int numRows, String exp) {
    ZigZagConversion zzg = new ZigZagConversion();
    String act = zzg.convert(s, numRows);
    Assert.assertEquals(act, exp);
  }

  @Test(dataProvider = "default")
  public void testConvert1(String s, int numRows, String exp) {
    ZigZagConversion zzg = new ZigZagConversion();
    String act = zzg.convert1(s, numRows);
    Assert.assertEquals(act, exp);
  }

  @DataProvider(name = "default")
  Object[][] dataset() {
    return new Object[][]{
            {"PAYPALISHIRING",3, "PAHNAPLSIIGYIR"},
            {"A",1,"A"}
    };
  }

}