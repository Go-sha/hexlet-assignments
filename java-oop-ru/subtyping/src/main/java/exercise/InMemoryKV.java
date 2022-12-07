package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    private Map<String, String> dictionary = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        this.dictionary.putAll(map);
    }

    @Override
    public void set(String key, String value) {
        this.dictionary.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.dictionary.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.dictionary.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> result = new HashMap<>();
        result.putAll(this.dictionary);
        return result;
    }
}
// END
