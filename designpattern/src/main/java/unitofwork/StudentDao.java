package unitofwork;

public interface StudentDao {
  void insert(Student student);
  void modify(Student student);
  void delete(Student student);
}
