package abstractdocument;

import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    var wheelProperties = Map.of(
            Property.TYPE.toString(), "wheel",
            Property.MODEL.toString(), "15C",
            Property.PRICE.toString(), 100L);

    var doorProperties = Map.of(
            Property.TYPE.toString(), "door",
            Property.MODEL.toString(), "Lambo",
            Property.PRICE.toString(), 300L);

    var carProperties = Map.of(
            Property.MODEL.toString(), "300SL",
            Property.PRICE.toString(), 10000L,
            Property.PARTS.toString(), List.of(wheelProperties, doorProperties));

    var car = new Car(carProperties);
    car.getParts().forEach(p -> {
      System.out.println(p.getType().orElse(null));
      System.out.println(p.getModel().orElse(null));
      System.out.println(p.getPrice().orElse(null));
    });
  }
}
