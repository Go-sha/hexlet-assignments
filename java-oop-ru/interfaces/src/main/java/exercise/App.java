package exercise;

import java.util.*;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> homeList, int n) {
        List<String> result = new LinkedList<>();
        LinkedHashMap<Home, Double> sortedMap = new LinkedHashMap<>();
        ArrayList<Double> list = new ArrayList<>();
        int counter = 0;

        for (Home home: homeList) {
            sortedMap.put(home, home.getArea());
        }
        for (Map.Entry<Home, Double> entry : sortedMap.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort(Comparator.naturalOrder());

        for (Double item : list) {
            for (Map.Entry<Home, Double> entry : sortedMap.entrySet()) {
                if (entry.getValue().equals(item) && counter < n) {
                    result.add(entry.getKey().toString());
                    counter ++;
                }
            }
        }

        return result;
    }
}
// END
