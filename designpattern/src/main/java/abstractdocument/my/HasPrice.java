package abstractdocument.my;

public interface HasPrice extends Document{
  String KEY = "PRICE";

  default Double getPrice() {
    return (Double) get(KEY);
  }
}
