package acyclicvisitor.my;

import java.util.Set;

public class Main {
  public static void main(String[] args) {
    var fileVisitor = new TypedVisitor<File>(){

      @Override
      public void doVisit(Object o) {
        File file = (File) o;
        System.out.println(file);
      }

      @Override
      public Class<File> getType() {
        return File.class;
      }
    };
    var folderVisitor = new TypedVisitor<Folder>(){

      @Override
      public void doVisit(Object o) {
        Folder folder = (Folder) o;
        System.out.println(folder);
      }

      @Override
      public Class<Folder> getType() {
        return Folder.class;
      }
    };
    var uniVisitor = new Visitor() {

      Set<Visitor> visitors = Set.of(fileVisitor, folderVisitor);

      @Override
      public void visit(Object o) {
        visitors.forEach(v -> v.visit(o));
      }
    };
    var file = new File();
    var folder = new Folder();

    file.accept(uniVisitor);
    folder.accept(uniVisitor);

  }
}
