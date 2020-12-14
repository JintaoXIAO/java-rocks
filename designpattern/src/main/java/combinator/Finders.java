package combinator;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finders {
  private Finders(){}

  public static Finder advancedFinder(String query, String orQuery, String notQuery) {
    return Finder.contains(query).or(Finder.contains(orQuery)).not(Finder.contains(notQuery));
  }

  public static Finder filteredFinder(String query, String ... excludeQueries) {
    var finder = Finder.contains(query);
    for (String q : excludeQueries) {
      finder = finder.not(Finder.contains(q));
    }
    return finder;
  }

  public static Finder specializedFinder(String... queries) {
    var finder = identMult();
    for (String q : queries) {
      finder = finder.and(Finder.contains(q));
    }
    return finder;
  }

  public static Finder expandedFinder(String... queries) {
    var finder = identSum();
    for (String query : queries) {
      finder = finder.or(Finder.contains(query));
    }
    return finder;
  }

  private static Finder identMult() {
    return text -> Stream.of(text.split("\n")).collect(Collectors.toList());
  }

  private static Finder identSum() {
    return text -> new ArrayList<>();
  }

}
