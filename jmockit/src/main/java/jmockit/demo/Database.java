package jmockit.demo;

import java.util.List;

public class Database {
  private Database() {

  }

  public static void persist(EntityX data) {
    System.out.println("persisted");
  }

  public static List<EntityX> find(String s, Object someProperty) {
    System.out.println("finded");
    return List.of();
  }

}
