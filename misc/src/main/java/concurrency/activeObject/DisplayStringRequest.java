package concurrency.activeObject;

public class DisplayStringRequest extends MethodRequest<String> {
  private final String s;
  public DisplayStringRequest(Servant servant, String str) {
    super(servant, null);
    this.s = str;
  }

  @Override
  public void execute() {
    super.servant.displayString(s);
  }
}
