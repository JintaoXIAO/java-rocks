package combinator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
public interface Finder {
  List<String> find(String text);

  static Finder contains(String word) {
    return text -> Stream.of(text.split("\n"))
            .filter(line -> line.toLowerCase().contains(word.toLowerCase()))
            .collect(Collectors.toList());
  }

  default Finder not(Finder notFinder) {
    return text -> {
      List<String> finds = this.find(text);
      finds.remove(notFinder.find(text));
      return finds;
    };
  }

  default Finder or(Finder orFinder) {
    return text -> {
      List<String> finds = this.find(text);
      finds.addAll(orFinder.find(text));
      return finds;
    };
  }

  default Finder and(Finder andFinder) {
    return text -> find(text).stream()
            .flatMap(line -> andFinder.find(line).stream())
            .collect(Collectors.toList());
  }

}
