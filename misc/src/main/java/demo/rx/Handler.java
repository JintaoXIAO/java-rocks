package demo.rx;

@FunctionalInterface
public interface Handler<T> {
  void handle(T t);
}
