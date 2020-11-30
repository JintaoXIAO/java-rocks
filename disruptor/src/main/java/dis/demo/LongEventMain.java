package dis.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class LongEventMain {
  public static void main(String[] args) throws InterruptedException {

    LongEventFactory lef = new LongEventFactory();

    int bufferSize = 1024;

    Disruptor<LongEvent> disruptor = new Disruptor<>(lef, bufferSize, DaemonThreadFactory.INSTANCE);

    disruptor.handleEventsWith(new LongEventHandler());
    disruptor.start();

    RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

    LongEventProducer producer = new LongEventProducer(ringBuffer);

    ByteBuffer buf = ByteBuffer.allocate(8);
    for (int i = 0; i < 1000; i++) {
      buf.putLong(0, i);
      producer.onData(buf);
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
