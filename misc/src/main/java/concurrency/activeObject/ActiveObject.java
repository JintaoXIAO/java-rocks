package concurrency.activeObject;

public interface ActiveObject {
  Result<String> makeString(int count, char c);
  void displayString(String str);
}
