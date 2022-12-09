package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    public SingleTag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes.putAll(attributes);
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

        return result.toString();
    }
}
// END
