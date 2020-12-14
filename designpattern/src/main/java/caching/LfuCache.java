package caching;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LfuCache<K, V> implements Cache<K, V>{

  private int initialCapacity = 10;
  private LinkedHashMap<K, CacheEntry<V>> cacheMap = new LinkedHashMap<>();

  public LfuCache(int initialCapacity) {
    this.initialCapacity = initialCapacity;
  }

  public K getLFUKey() {
    return cacheMap.entrySet()
            .stream()
            .reduce((e1, e2) -> {
              if (e1.getValue().frequency > e2.getValue().frequency) return e2;
              else return e1;
            }).orElseThrow().getKey();
  }

  public void addCacheEntry(K key, V val) {
    if (!isFull()) {
      CacheEntry<V> c = new CacheEntry<>();
      c.setFrequency(0);
      c.setDate(val);
      cacheMap.put(key, c);
    } else {

    }
  }

  public V getCacheEntry(K key) {
    if (cacheMap.containsKey(key)) {
      CacheEntry<V> c = cacheMap.get(key);
      c.frequency ++;
      cacheMap.put(key, c);
      return c.date;
    }
    return null;
  }

  public boolean isFull() {
    return (cacheMap.size() == initialCapacity);
  }

  @Override
  public V get(K key) {
    return null;
  }

  @Override
  public V update(K key, V val) {
    return null;
  }

  @Override
  public boolean contains(K key) {
    return false;
  }

  @Override
  public V remove(K key) {
    return null;
  }

  @Override
  public Iterator<K> iterator() {
    return null;
  }

  class CacheEntry<T> {
    private T date;
    private int frequency;

    private CacheEntry() {
    }

    public T getDate() {
      return date;
    }

    public void setDate(T date) {
      this.date = date;
    }

    public int getFrequency() {
      return frequency;
    }

    public void setFrequency(int frequency) {
      this.frequency = frequency;
    }
  }
}
