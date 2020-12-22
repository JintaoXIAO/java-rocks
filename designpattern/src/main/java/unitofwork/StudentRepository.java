package unitofwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository implements IUnitOfWork<Student>{

  private final Map<UnitAction, List<Student>> context;
  private final StudentDao studentDao;

  public StudentRepository(Map<UnitAction, List<Student>> context, StudentDao studentDao) {
    this.context = context;
    this.studentDao = studentDao;
  }

  @Override
  public void registerNew(Student entity) {
    register(entity, UnitAction.INSERT);
  }

  @Override
  public void registerModified(Student entity) {
    register(entity, UnitAction.MODIFY);
  }

  @Override
  public void registerDeleted(Student entity) {
    register(entity, UnitAction.DELETE);
  }

  @Override
  public void commit() {
  }

  private void commitInsert() {

  }

  private void register(Student student, UnitAction operation) {
    var studentsToOperate = context.get(student);
    if (studentsToOperate == null) {
      studentsToOperate = new ArrayList<>();
    }
    studentsToOperate.add(student);
    context.put(operation, studentsToOperate);
  }
}
