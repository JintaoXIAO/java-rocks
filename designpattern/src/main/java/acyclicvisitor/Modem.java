package acyclicvisitor;

public interface Modem {
  void accept(ModemVisitor modemVisitor);
}
