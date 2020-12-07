package acyclicvisitor;

public class Zoom implements Modem{
  @Override
  public void accept(ModemVisitor modemVisitor) {
    if (modemVisitor instanceof ZoomVisitor) {
      ((ZoomVisitor) modemVisitor).visit(this);
    } else {
      System.err.println("Only zoomVisitor is allowed to visit Zoom modem");
    }
  }

  @Override
  public String toString() {
    return "Zoom modem";
  }
}
