package mapdb.demo;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

import java.util.concurrent.ConcurrentMap;

public class Demo1 {
  public static void main(String[] args) {
    DB db = DBMaker
            .fileDB("my.db")
            .make();

    HTreeMap<String, Integer> map = db
            .hashMap("hmap")
            .keySerializer(Serializer.STRING)
            .valueSerializer(Serializer.INTEGER)
            .createOrOpen();

    map.put("a", 123);
    map.put("b", 345);
    map.put("c", 456);

    map.close();


  }
}
