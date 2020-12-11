package demo.rx;

import java.util.function.Function;

public class Main1 {
  public static void main(String[] args) {

    Calc calc = new Calc();
    calc.m1(3, r -> {
      calc.m2(r, r1 -> {
        calc.m3(r1, r2 -> {
          System.out.println("finished");
        });
      });
    });

  }
}




class Calc1 {
  private Calc calc = new Calc();

  Calc1 m1(int a, CalcStep result) {
    calc.m1(a, r -> result.setValue(r));
    return this;
  }

  Calc1 m2(int b, CalcStep calcStep) {
    calc.m2(b, r -> calcStep.setValue(r));
    return this;
  }

  Calc1 m3(int b, CalcStep calcStep) {
    calc.m3(b, r -> calcStep.setValue(r));
    return this;
  }
}

class Calc {
  void m1(int a, Handler<Integer> handler) {
    a += 1;
    System.out.println("calc1 " + a);
    handler.handle(a);
  }

  void m2(int a, Handler<Integer> handler) {
    a += 2;
    System.out.println("calc2 " + a);
    handler.handle(a);
  }

  void m3(int a, Handler<Integer> handler) {
    a += 3;
    System.out.println("calc3 " + a);
    handler.handle(a);
  }
}

class CalcStep implements Result<Integer>{

  private int value;

  private Throwable throwable;

  @Override
  public boolean isSuccess() {
    return false;
  }

  public void setValue(int i) {
    this.value = i;
  }

  @Override
  public Integer get() {
    return this.value;
  }

  public void setEx(Throwable throwable) {
    this.throwable = throwable;
  }

  @Override
  public Throwable getEx() {
    return this.throwable;
  }
}