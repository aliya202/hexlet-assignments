package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        return homes.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(n)
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}

// END
