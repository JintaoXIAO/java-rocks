package concurrency.activeObject;

public class RealResult<T> extends Result<T> {
  private T value;

  public RealResult(T value) {
    this.value = value;
  }

  @Override
  public T getResultValue() {
    return value;
  }
}

