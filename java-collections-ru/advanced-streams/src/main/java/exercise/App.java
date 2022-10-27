package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String getForwardedVariables(String str) {
        String ret;
        List<String> lines = List.of(str.split("\n"));

        ret =  lines.stream()
                .filter(App::isEnvironment)
                .map(App::getVariables)
                .collect(Collectors.joining());

        if (ret.endsWith(",")) {
            ret = ret.substring(0, ret.length() - 1);
        }
        return ret;
    }

    public static String getVariables(String str) {
       str = App.clearString(str);
       List<String> list = List.of(str.split(","));

        return list.stream()
               .filter(x->x.contains("X_FORWARDED_"))
               .map(x->x.replace("X_FORWARDED_", ""))
               .map(x->x + ",")
               .collect(Collectors.joining());
    }
    public static boolean isEnvironment(String str) {
       return str.startsWith("environment=\"") && str.endsWith("\"");
    }

    public static String clearString(String str) {
        return str.replace("environment=", "").replace("\"", "");
    }
}
//END
