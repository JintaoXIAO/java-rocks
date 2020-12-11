package acyclicvisitor.my;

public interface TypedVisitorRegistry {
  void registryVisitor(Class<?> clz, Visitor visitor);
}
