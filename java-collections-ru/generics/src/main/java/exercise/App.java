package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(
                                                List<Map<String, String>> books,
                                                Map<String, String> where) {
        List<Map<String, String>> answer = new ArrayList<>();
        if (where.size() == 0) {
            return answer;
        }

        for (Map<String, String> book: books) {
            boolean addBook = true; 

            for (Map.Entry<String, String> pair: where.entrySet()) {
                String bookValue = book.get(pair.getKey());

                if (!bookValue.equals(pair.getValue())) {
                    addBook = false;
                    break;
                }
            }

            if (addBook) {
                answer.add(book);
            }
        }

        return answer;
    }
}
//END
