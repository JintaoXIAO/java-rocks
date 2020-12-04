package abstractdocument;

import java.util.Map;

public class Car extends AbstractDocument implements HasModel, HasParts, HasPrice{
  protected Car(Map<String, Object> properties) {
    super(properties);
  }
}
