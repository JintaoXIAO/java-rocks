package abstractdocument;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class AbstractDocument implements Document{
  private final Map<String, Object> properties;

  protected AbstractDocument(Map<String, Object> properties) {
    Objects.requireNonNull(properties, "properties map is required");
    this.properties = properties;
  }

  @Override
  public Void put(String key, Object value) {
    properties.put(key,value);
    return null;
  }

  @Override
  public Object get(String key) {
    return properties.get(key);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
    return Stream.ofNullable(get(key))
            .filter(Objects::nonNull)
            .map(e -> (List<Map<String, Object>>) e)
            .findAny()
            .stream()
            .flatMap(Collection::stream)
            .map(constructor);
  }
}
