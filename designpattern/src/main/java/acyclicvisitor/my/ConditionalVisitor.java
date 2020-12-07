package acyclicvisitor.my;

public interface ConditionalVisitor extends Visitor {
  boolean canVisit(Object t);

  default void visit(Object t) {
    if (canVisit(t)) {
      doVisit(t);
    }
  }

  void doVisit(Object t);
}
