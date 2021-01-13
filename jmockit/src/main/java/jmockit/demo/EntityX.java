package jmockit.demo;

import java.math.BigDecimal;

public class EntityX {
  private int id;
  private BigDecimal total;
  private String customerEmail;
  private String someProperty;

  public void setId(int id) {
    this.id = id;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setSomeProperty(String someProperty) {
    this.someProperty = someProperty;
  }

  public EntityX(int i, String abc, String s) {
    this.id = i;
    this.someProperty = abc;
    this.customerEmail = s;
  }

  public Object getSomeProperty() {
    return someProperty;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public int getId() {
    return id;
  }

  public void setCustomerEmail(String email) {
    this.customerEmail = email;
  }
}
