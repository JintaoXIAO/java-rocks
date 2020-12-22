package unitofwork;

public class Student {
  private final Integer id;
  private final String name;
  private final String address;

  public Student(Integer id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }
}
