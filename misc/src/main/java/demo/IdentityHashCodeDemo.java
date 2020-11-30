package demo;

import java.util.Objects;

public class IdentityHashCodeDemo {
  public static void main(String[] args) {
    IHC ihc = new IHC();
    int ih = System.identityHashCode(ihc);
    int h = ihc.hashCode();
    System.out.println("identityHashCode: " + ih);
    System.out.println("hashCode: " + h);
  }
}
class IHC {
  private String name;
  private int age;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IHC ihc = (IHC) o;
    return age == ihc.age &&
            Objects.equals(name, ihc.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
