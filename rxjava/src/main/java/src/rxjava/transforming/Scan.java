package rxjava.transforming;

import io.reactivex.internal.operators.flowable.FlowableJust;

public class Scan {
  public static void main(String[] args) {
    System.out.println("scan:");
    FlowableJust.fromArray(1, 2, 3, 4, 5)
            .scan((a,b)-> a+b)
            .subscribe(i -> System.out.println(i));

    System.out.println("reduce:");
    FlowableJust.fromArray(1, 2, 3, 4, 5)
            .reduce((a,b)->a + b)
            .subscribe(i -> System.out.println(i));


  }
}
