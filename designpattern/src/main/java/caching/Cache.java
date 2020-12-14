package caching;

public interface Cache<K, V> extends Iterable<K>{
  V get(K key);
  V update(K key, V val);
  boolean contains(K key);
  V remove(K key);

  default Cache<K, V> lruCache(int capacity) {
    return new LruCache<K, V>(capacity);
  }

  default Cache<K, V> lfuCache(int capacity) {
    return new LfuCache<K, V>(capacity);
  }
}
