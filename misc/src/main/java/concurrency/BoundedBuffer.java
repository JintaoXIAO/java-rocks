package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
  final Lock lock = new ReentrantLock();
  final Condition notFull = lock.newCondition();
  final Condition notEmpty = lock.newCondition();


  final Object[] items = new Object[10];
  int count;
  int takePtr;
  int putPrt;

  public void put(Object x) throws InterruptedException {
    try {
      lock.lock();
      while (takePtr == items.length) {
        notFull.await();
      }
      items[takePtr++] = x;
      count ++;
      notEmpty.signal();
    }finally {
      lock.unlock();
    }
  }

  public Object take() throws InterruptedException {
    try {
      lock.lock();
      while (putPrt == 0) {
        notEmpty.await();
      }
      Object o = items[putPrt++];
      count --;
      notFull.signal();
      return o;
    }finally {
      lock.unlock();
    }
  }
}
