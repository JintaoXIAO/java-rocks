package demo;

public class EnumDemo {
  public static void main(String[] args) {
    Season season = NoneExistedSeason.INSTANCE;
    System.out.println(season.desc());
  }
}

interface Season {
  String desc();
}

enum NoneExistedSeason implements Season {
  INSTANCE() {
    @Override
    public String desc() {
      return "none existed season";
    }
  };
}
