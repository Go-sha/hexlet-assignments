package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
import java.lang.StringBuilder;

class App {
    public static Map<String, Integer>  getWordCount(String sentence) {
        int i;
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = sentence.split(" ");

        for (String word: words) {
            if (word.length() > 0) {
                int value = 0;
                if (wordsMap.containsKey(word)) {
                    value = wordsMap.get(word);
                }
                wordsMap.put(word, value + 1);
            }
        }

        return wordsMap;
    }

    public static String toString(Map<String, Integer> map) {
        var result = new StringBuilder();

        result.append("{");
        if (map.size() > 0) {
            result.append("\n");
            for (Map.Entry<String, Integer> word: map.entrySet()) {
                result.append("  " + word.getKey() + ": "
                              + word.getValue() + "\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
//END
