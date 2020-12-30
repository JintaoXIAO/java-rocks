package xstream.demo;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] args) throws ParseException, IOException {
    Customer customer = new Customer();
    customer.setFirstName("Jim");
    customer.setLastName("Green");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date dob = sdf.parse("1986-02-14 03:46:16");
    customer.setDob(dob);

    XStream xStream = new XStream();
    xStream.alias("customer", Customer.class);
    //xStream.toXML(customer, new FileWriter(new File("customer.new.xml")));
    Customer c = (Customer) xStream.fromXML(new File("/home/jintao/Prj/java-rocks/customer.new.xml"));
    System.out.println(c);

  }

}
