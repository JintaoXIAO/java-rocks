package caching;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LfuCache<T> {

  private int initialCapacity = 10;
  private LinkedHashMap<Integer, CacheEntry<T>> cacheMap = new LinkedHashMap<>();

  public LfuCache(int initialCapacity) {
    this.initialCapacity = initialCapacity;
  }

  public int getLFUKey() {
    return cacheMap.entrySet()
            .stream()
            .reduce((e1, e2) -> {
              if (e1.getValue().frequency > e2.getValue().frequency) return e2;
              else return e1;
            }).orElseThrow().getKey();
  }

  public void addCacheEntry(int key, T data) {
    if (!isFull()) {
      CacheEntry<T> c = new CacheEntry<>();
      c.setFrequency(0);
      c.setDate(data);
      cacheMap.put(key, c);
    } else {

    }
  }

  public T getCacheEntry(int key) {
    if (cacheMap.containsKey(key)) {
      CacheEntry<T> c = cacheMap.get(key);
      c.frequency ++;
      cacheMap.put(key, c);
      return c.date;
    }
    return null;
  }

  public boolean isFull() {
    return (cacheMap.size() == initialCapacity);
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
