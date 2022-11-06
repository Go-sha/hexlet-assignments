package exercise;

import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1,
                                                        Map<String, Object> map2) {
       LinkedHashMap<String, String> result = new LinkedHashMap<>();

        for (Map.Entry<String, Object> entry: map1.entrySet()) {
            compareValues(entry.getKey(), entry.getValue(), map2, result);
        }
        for (Map.Entry<String, Object> entry: map2.entrySet()) {
            result.putIfAbsent(entry.getKey(), "added");
        }

        return result;
    }

    public static void compareValues(String key, Object value,
                                     Map<String, Object> map,
                                     LinkedHashMap<String, String> result) {
        if (map.containsKey(key)) {
            if(map.get(key).equals(value)) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        } else {
            result.put(key,  "deleted");
        }
    }
}
//END
