package dis.demo;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class LongEventProducer {
  private final RingBuffer<LongEvent> ringBuffer;

  public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void onData(ByteBuffer buf) {
    long seq = ringBuffer.next();
    try {
      LongEvent e = ringBuffer.get(seq);
      e.setValue(buf.getLong(0));
    } finally {
      ringBuffer.publish(seq);
    }
  }
}
