package rxjava.conditional;

import io.reactivex.Observable;

public class All {
  public static void main(String[] args) {
    Observable.fromArray("hello", "world", "from", "jintao")
            .all(s -> s.length() > 3)
            .subscribe(System.out::println);

  }
}
