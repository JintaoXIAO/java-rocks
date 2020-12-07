package acyclicvisitor;

public class Main {
  public static void main(String[] args) {
    var conDos = new ConfigureForDosVisitor();
    var zoom = new Zoom();
    var hayes = new Hayes();

    hayes.accept(conDos);
    zoom.accept(conDos);

  }
}
