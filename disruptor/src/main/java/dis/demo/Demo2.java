package dis.demo;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.TimeUnit;

public class Demo2 {
  public static void main(String[] args) throws InterruptedException {
    LongEventFactory eventFactory = new LongEventFactory();
    int bufferSize = 64;

    Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, bufferSize, DaemonThreadFactory.INSTANCE);
    disruptor.handleEventsWith(new LongEventHandler());
    disruptor.start();

    RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
    EventProducer eventProducer = new EventProducer(ringBuffer);

    for (int i = 0; i < 80; i++) {
      eventProducer.publish(i);
      TimeUnit.MILLISECONDS.sleep(300);
    }
  }
}

class EventProducer {
  private RingBuffer<LongEvent> ringBuffer;

  EventProducer(RingBuffer<LongEvent> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void publish(long val) {
    this.ringBuffer.publishEvent((event, sequence) -> event.setVal(val));
  }
}

class LongEventHandler implements EventHandler<LongEvent> {

  @Override
  public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
    System.out.printf("process event: %s at Sequence[%d]\n", event, sequence);
  }
}

class LongEventFactory implements EventFactory<LongEvent> {

  @Override
  public LongEvent newInstance() {
    return new LongEvent();
  }
}

class LongEvent {
  private long val;

  public long getVal() {
    return val;
  }

  public void setVal(long val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "LongEvent{" +
            "val=" + val +
            '}';
  }
}
