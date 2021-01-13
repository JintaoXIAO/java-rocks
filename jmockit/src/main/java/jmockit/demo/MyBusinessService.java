package jmockit.demo;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.math.BigDecimal;
import java.util.List;

import static jmockit.demo.Database.find;
import static jmockit.demo.Database.persist;

public final class MyBusinessService {
  private final EntityX data;

  public MyBusinessService(EntityX data) {
    this.data = data;
  }

  public void doBusinessOperationXyz() throws EmailException {
    List<EntityX> items =
            find("select item from EntityX item where item.someProperty = ?1", data.getSomeProperty());
    BigDecimal total = BigDecimal.TEN;
    data.setTotal(total);
    persist(data);
    sendNotificationEmail(items);
  }

  private void sendNotificationEmail(List<EntityX> items) throws EmailException {
    Email email = new SimpleEmail();
    email.setSubject("Notification about processing of ...");
    email.addTo(data.getCustomerEmail());
    String message = buildNotificationMessage(items);
    email.setMsg(message);
    email.send();
  }

  private String buildNotificationMessage(List<EntityX> items) {
    return null;
  }

}
