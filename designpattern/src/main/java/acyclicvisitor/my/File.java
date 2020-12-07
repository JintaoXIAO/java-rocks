package acyclicvisitor.my;

public class File implements Visitorable{
  @Override
  public String toString() {
    return "this is a file";
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
