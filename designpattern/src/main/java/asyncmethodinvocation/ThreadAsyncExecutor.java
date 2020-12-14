package asyncmethodinvocation;

import java.rmi.server.ExportException;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAsyncExecutor implements AsyncExecutor{

  private final AtomicInteger idx = new AtomicInteger(0);

  @Override
  public <T> AsyncResult<T> startProcess(Callable<T> task) {
    return startProcess(task, null);
  }

  @Override
  public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
    return null;
  }

  @Override
  public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
    return null;
  }


  private static class CompletableResult<T> implements AsyncResult<T> {

    static final int RUNNING = 1;
    static final int FAILED = 2;
    static final int COMPLETED = 3;

    final Object lock;
    final Optional<AsyncCallback<T>> callback;
    volatile int state = RUNNING;
    T value;
    Exception exception;

    CompletableResult(AsyncCallback<T> callback) {
      this.lock = new Object();
      this.callback = Optional.ofNullable(callback);
    }

    void setValue(T value) {
      this.value = value;
      this.state = COMPLETED;
      this.callback.ifPresent(c -> c.onComplete(value, Optional.empty()));
      synchronized (lock) {
        lock.notifyAll();
      }
    }

    void setException(Exception e) {
      this.exception = e;
      this.state = FAILED;
      this.callback.ifPresent(c -> c.onComplete(null, Optional.of(e)));
      synchronized (lock) {
        lock.notifyAll();
      }
    }

    @Override
    public boolean isCompleted() {
      return state > RUNNING;
    }

    @Override
    public T getValue() throws ExecutionException {
      if (state == COMPLETED) {
        return value;
      } else if (state == FAILED) {
        throw new ExecutionException(exception);
      } else {
        throw new IllegalStateException("Execution not completed yet");
      }
    }

    @Override
    public void await() throws InterruptedException {
      synchronized (lock) {
        while (!isCompleted()) {
          lock.wait();
        }
      }
    }
  }
}
