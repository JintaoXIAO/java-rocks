package rxjava.misc;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import org.jetbrains.annotations.NotNull;

public class MyObservable<T> implements ObservableSource<T> {
  @Override
  public void subscribe(@NotNull Observer<? super T> observer) {

  }
}
