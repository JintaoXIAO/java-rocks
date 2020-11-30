package concurrency.activeObject;

public class ActivationQueue {
  private final static int MAX_METHOD_REQUEST = 100;
  private MethodRequest[] requests;
  private int tail;
  private int head;
  private int count;

  public ActivationQueue() {
    this.requests = new MethodRequest[MAX_METHOD_REQUEST];
    this.head = 0;
    this.tail = 0;
    this.count = 0;
  }

  public synchronized void putRequest(MethodRequest req){
    while (count >= requests.length) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    tail = (tail + 1) % requests.length;
    requests[tail] = req;
    count++;
    notifyAll();
  }

  public synchronized MethodRequest takeRequest() {
    while (count <= 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    head = (head + 1) % requests.length;
    MethodRequest r = requests[head];
    count --;
    notifyAll();
    return r;
  }



}
