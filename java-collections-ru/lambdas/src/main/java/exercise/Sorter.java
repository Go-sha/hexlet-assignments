package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        return list.stream()
            .filter(Sorter::isMale)
            .sorted((x, y) -> compareByDate(x, y))
            .map(m -> getName(m))
            .collect(Collectors.toList());
    }
    
    public static boolean isMale(Map<String, String> map) {
        return map.get("gender").equals("male");
    }

    public static Integer compareByDate(Map<String, String> x,
                                                  Map<String, String> y) {
        String date1 = x.get("birthday");
        String date2 = y.get("birthday");
        String[] firstDate = date1.split("-");
        String[] secondDate = date2.split("-");

        if (Integer.parseInt(firstDate[0]) > Integer.parseInt(secondDate[0])) {
            return 1;
        }
        if (Integer.parseInt(firstDate[0]) < Integer.parseInt(secondDate[0])) {
            return -1;
        }

        if (Integer.parseInt(firstDate[1]) > Integer.parseInt(secondDate[1])) {
            return 1;
        }
        if (Integer.parseInt(firstDate[1]) < Integer.parseInt(secondDate[1])) {
            return -1;
        }

        if (Integer.parseInt(firstDate[2]) > Integer.parseInt(secondDate[2])) {
            return 1;
        }
        if (Integer.parseInt(firstDate[2]) < Integer.parseInt(secondDate[2])) {
            return -1;
        }

        return 0;
    }

    public static String getName(Map<String, String> map) {
        return map.get("name");
    }
}
// END
