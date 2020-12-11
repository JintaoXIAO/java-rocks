package demo.rx;

public interface Result<T> {

  boolean isSuccess();
  T get();
  Throwable getEx();

}
