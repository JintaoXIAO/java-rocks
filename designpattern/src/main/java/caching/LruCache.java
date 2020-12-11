package caching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {
  class Node {
    String userId;
    UserAccount account;
    Node previous, next;

    public Node(String userId, UserAccount account) {
      this.userId = userId;
      this.account = account;
    }
  }
  int capacity;
  Map<String, Node> cache = new HashMap<>();
  Node head, tail;

  public LruCache(int capacity) {
    this.capacity = capacity;
  }

  public UserAccount get(String userId) {
    if (cache.containsKey(userId)) {
      var node = cache.get(userId);
      remove(node);
      setHead(node);
      return node.account;
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

  public void update(String userId, UserAccount userAccount) {
    if (cache.containsKey(userId)) {
      var old = cache.get(userId);
      old.account = userAccount;
      remove(old);
      setHead(old);
    } else {
      var newNode = new Node(userId, userAccount);
      if (cache.size() >= capacity) {
        cache.remove(tail.userId);
        remove(head);
      }
      setHead(newNode);
      cache.put(userId, newNode);
    }
  }

  public boolean contains(String userId) {
    return cache.containsKey(userId);
  }

  public void invalidate(String userId) {
    var toBeRemoved = cache.remove(userId);
    if (toBeRemoved != null) {
      remove(toBeRemoved);
    }
  }

  public boolean isFull() {
    return cache.size() >= capacity;
  }

  public UserAccount getLruData() {
    return tail.account;
  }

  public void clear() {
    head = null;
    tail = null;
    cache.clear();
  }

  public List<UserAccount> getCacheDataInListForm() {
    var listOfCacheData = new ArrayList<UserAccount>();
    var temp = head;
    while (temp != null) {
      listOfCacheData.add(temp.account);
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
