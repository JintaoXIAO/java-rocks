package acyclicvisitor;

public class ConfigureForDosVisitor implements AllModemVisitor{
  @Override
  public void visit(Hayes hayes) {
    System.out.println(hayes + " used with dos configurator");
  }

  @Override
  public void visit(Zoom zoom) {
    System.out.println(zoom + " used with dos configurator");
  }
}
