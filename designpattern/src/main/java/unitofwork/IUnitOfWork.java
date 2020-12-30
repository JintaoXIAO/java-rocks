package unitofwork;

public interface IUnitOfWork<T> {
  void registerNew(T entity);
  void registerModified(T entity);
  void registerDeleted(T entity);
  void commit();
}
