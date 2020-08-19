package demo.rxjava.misc;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.concurrent.Flow;

public class Demo1 {
  public static void main(String[] args) {
    Subject<String> subj = PublishSubject.create();
    subj.subscribe(s -> System.out.println(s));

    subj.onNext("hello");
    subj.onNext("world");
    subj.onComplete();
  }
}
