package concurrency.activeObject;

public class MakeStringRequest extends MethodRequest<String> {

  private final int count;
  private final char c;

  public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char c) {
    super(servant, future);
    this.count = count;
    this.c = c;
  }

  @Override
  public void execute() {
    Result<String> r = super.servant.makeString(this.count, this.c);
    super.future.setResult(r);
  }
}
