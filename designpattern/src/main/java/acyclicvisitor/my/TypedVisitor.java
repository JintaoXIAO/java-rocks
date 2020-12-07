package acyclicvisitor.my;

public interface TypedVisitor<T> extends ConditionalVisitor {

  Class<T> getType();

  @Override
  default boolean canVisit(Object t){
    return t.getClass() == getType();
  }
}
