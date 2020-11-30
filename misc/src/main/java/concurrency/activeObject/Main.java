package concurrency.activeObject;

public class Main {
  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
    new MakerClientThread("alice", activeObject).start();
    new MakerClientThread("bob", activeObject).start();
    new DisplayClientThread("Chris", activeObject).start();
  }
}
