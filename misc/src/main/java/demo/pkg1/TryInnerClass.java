package demo.pkg1;

import demo.InnerClass;

public class TryInnerClass {
  public static void main(String[] args) {
    InnerClass ic = new InnerClass(){
      {
        doSomething();
      }
    };


/*
    new IOOperationContext(input, output) {{
      writeLine("input you name: ");
      String name = getLine();
      writeLine("input you age: ");
      int age = getInt();
      process(name, age);

    }};
*/
  }
}
