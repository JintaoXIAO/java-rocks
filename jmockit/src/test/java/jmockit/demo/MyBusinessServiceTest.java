package jmockit.demo;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

import static jmockit.demo.Database.persist;
import static org.testng.Assert.*;

public class MyBusinessServiceTest {
  @Tested final EntityX data = new EntityX(1, "abc", "someone@somewhere.com");
  @Tested(fullyInitialized = true) MyBusinessService businessService;
  @Mocked
  SimpleEmail anyEmail;

  @Test
  public void doBusinessOperationXyz() throws Exception {
    EntityX existingItem = new EntityX(1, "AX5", "abc@xpta.com");
    persist(existingItem);
    businessService.doBusinessOperationXyz();
    assertNotEquals(0, data.getId());
    new Verifications() {{
      anyEmail.send();
      times = 1;
    }};
  }

  @Test(expectedExceptions = EmailException.class)
  public void doBusinessOperationXyzWithInvalidEmailAddress() throws Exception {
    String email = "invalid address";
    data.setCustomerEmail(email);
    new Expectations() {{
      anyEmail.addTo(email);
      result = new EmailException();
    }};
    businessService.doBusinessOperationXyz();
  }
}