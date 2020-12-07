package abstractdocument.my;

public interface HasType extends Document{
  String KEY = "TYPE";

  default String getType() {
    return (String) get(KEY);
  }

}
