package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        if (emails == null)
            return 0;

        return emails.stream()
            .filter(email -> App.isFree(email))
            .count();
    }

    public static boolean isFree(String email) {
        return StringUtils.endsWith(email, "@gmail.com") |
               StringUtils.endsWith(email, "@yandex.ru") |
               StringUtils.endsWith(email, "@hotmail.com");
    }
}
// END
