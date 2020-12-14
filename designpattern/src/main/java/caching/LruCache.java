package caching;

import java.util.*;

public class LruCache<K, V> implements Cache<K, V>{
  @Override
  public Iterator<K> iterator() {
    return null;
  }

  class Node<K, V> {
    K key;
    V val;
    Node previous, next;

    public Node(K key, V val) {
      this.key = key;
      this.val = val;
    }
  }

  int capacity;
  Map<K, Node<K, V>> cache = new HashMap<>();
  Node<K, V> head, tail;

  public LruCache(int capacity) {
    this.capacity = capacity;
  }

  public V get(K key) {
    if (cache.containsKey(key)) {
      var node = cache.get(key);
      remove(node);
      setHead(node);
      return node.val;
    }
    return null;
  }

  public void remove(Node node) {
    if (node.previous != null) {
      node.previous.next = node.next;
    } else {
      head = node.next;
    }
    if (node.next != null) {
      node.next.previous = node.previous;
    } else {
      tail = node.previous;
    }
  }

  public void setHead(Node node) {
    node.next = head;
    node.previous = null;
    if (head != null) {
      head.previous = node;
    }
    head = node;
    if (tail == null) {
      tail = head;
    }
  }

  public V update(K key, V val) {
    if (cache.containsKey(key)) {
      var old = cache.get(key);
      V oldValue = old.val;
      old.val = val;
      remove(old);
      setHead(old);
      return oldValue;
    } else {
      var newNode = new Node(key, val);
      if (cache.size() >= capacity) {
        cache.remove(tail.key);
        remove(head);
      }
      setHead(newNode);
      cache.put(key, newNode);
      return null;
    }
  }

  public boolean contains(K key) {
    return cache.containsKey(key);
  }

  @Override
  public V remove(K key) {
    return null;
  }

  public void invalidate(K key) {
    var toBeRemoved = cache.remove(key);
    if (toBeRemoved != null) {
      remove(toBeRemoved);
    }
  }

  public boolean isFull() {
    return cache.size() >= capacity;
  }

  public V getLruData() {
    return tail.val;
  }

  public void clear() {
    head = null;
    tail = null;
    cache.clear();
  }

  public List<V> getCacheDataInListForm() {
    var listOfCacheData = new ArrayList<V>();
    var temp = head;
    while (temp != null) {
      listOfCacheData.add(temp.val);
      temp = temp.next;
    }
    return listOfCacheData;
  }

  public void setCapacity(int newCapacity) {
    if (capacity > newCapacity) {
      clear();
    } else {
      this.capacity = newCapacity;
    }
  }
}
