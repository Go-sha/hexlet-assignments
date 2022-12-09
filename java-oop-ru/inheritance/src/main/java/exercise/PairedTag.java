package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag{
    String body;
    List<Tag> children = new LinkedList<>();

    public PairedTag(String name, Map<String, String> attributes,
                     String body, List<Tag> children) {

        this.name = name;
        this.attributes.putAll(attributes);
        this.body = body;
        this.children.addAll(children);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("<");
        result.append(this.name);
        if (!this.attributes.isEmpty()) {
            for (Map.Entry<String, String> entry : this.attributes.entrySet()) {
                result.append(" ");
                result.append(entry.getKey());
                result.append("=\"");
                result.append(entry.getValue());
                result.append("\"");
            }
        }
        result.append(">");
        if (this.body != null && !this.body.equals("")) {
            result.append(body);
        }
        if (!children.isEmpty()) {
            for (Tag tag : this.children) {
                result.append(tag.toString());
            }
        }
        result.append("</");
        result.append(this.name);
        result.append(">");
        return result.toString();
    }
}
// END
