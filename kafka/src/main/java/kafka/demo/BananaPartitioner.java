package kafka.demo;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.utils.Utils;

import java.util.Map;

public class BananaPartitioner implements Partitioner {
  @Override
  public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
    var partitions = cluster.partitionsForTopic(topic);
    int numPartitions = partitions.size();
    if ((keyBytes == null) || !(key instanceof String))
      throw new InvalidRecordException("We expect all messages to have customer name as key");
    if ("Banana".equals(key)) return numPartitions;
    return (Math.abs(Utils.murmur2(keyBytes)) % (numPartitions - 1));
  }

  @Override
  public void close() {

  }

  @Override
  public void configure(Map<String, ?> configs) {

  }
}
