package abstractdocument.my;

public interface Document {

  default boolean has(String propKey) {
    return get(propKey) != null;
  }

  Object get(String propKey);

}
