package acyclicvisitor.my;

import java.util.HashMap;
import java.util.Map;

public class VisitorGroup implements Visitor, TypedVisitorRegistry{

  private final Map<Class<?>, Visitor> visitorMap;

  public VisitorGroup() {
    this.visitorMap = new HashMap<>();
  }

  @Override
  public void visit(Object o) {
    Visitor visitor = this.visitorMap.get(o.getClass());
    if (visitor != null) {
      visitor.visit(o);
    }
  }

  @Override
  public void registryVisitor(Class<?> clz, Visitor visitor) {
    this.visitorMap.put(clz, visitor);
  }
}
