package concurrency.activeObject;

public class Proxy implements ActiveObject {
  private final SchedulerThread schedulerThread;
  private final Servant servant;

  public Proxy(SchedulerThread schedulerThread, Servant servant) {
    this.schedulerThread = schedulerThread;
    this.servant = servant;
  }

  @Override
  public Result<String> makeString(int count, char c) {
    FutureResult<String> result = new FutureResult<>();
    schedulerThread.invoke(new MakeStringRequest(servant, result, count, c));
    return result;
  }

  @Override
  public void displayString(String str) {
    schedulerThread.invoke(new DisplayStringRequest(servant, str));
  }
}
