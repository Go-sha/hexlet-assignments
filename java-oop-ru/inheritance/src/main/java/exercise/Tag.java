package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public abstract class Tag {
    String name;
    final Map<String, String> attributes = new LinkedHashMap<>();

    public abstract String toString();
}
// END
