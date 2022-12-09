package exercise;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object instance) {
        List<String> result = new LinkedList<>();
        for (Field field : instance.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(instance) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}
// END
