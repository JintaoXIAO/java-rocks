package dis.demo;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {
  public static void main(String[] args) {

  }

  static class MessageProducer {
    private static final int DEFAULT_BUFFER_CAPACITY = 1024;
    private ByteBuffer buffer;
    private RingBuffer<MessageEvent> ringBuffer;

    public MessageProducer(RingBuffer<MessageEvent> ringBuffer) {
      this.buffer = ByteBuffer.allocate(DEFAULT_BUFFER_CAPACITY);
      this.ringBuffer = ringBuffer;
    }

    public void publish(MessageEvent messageEvent) {

    }

  }

  static class MessageEventFactory implements EventFactory<MessageEvent> {

    @Override
    public MessageEvent newInstance() {
      return new MessageEvent();
    }
  }

  static class MessageEvent implements Externalizable {
    private Map<String, String> head;
    private String payload;

    public MessageEvent() {
      this.head = new HashMap<>();
    }

    public void addHead(String key, String value) {
      this.head.put(key, value);
    }

    public void setPayload(String payload) {
      this.payload = payload;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      for (Map.Entry<String, String> e : head.entrySet()) {
        out.writeChars(e.getKey());
        out.writeChars(e.getValue());
      }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
  }
}


