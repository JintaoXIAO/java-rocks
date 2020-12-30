package kafka.demo;

import org.apache.kafka.clients.producer.ProducerRecord;

public class Main1 {
  public static void main(String[] args) {
    var record = new ProducerRecord<String, String>("CustomerCountry", "Laboratory Equipment", "USA");

    var record1 = new ProducerRecord<String, String>("CustomerCountry", "USA");
  }
}
