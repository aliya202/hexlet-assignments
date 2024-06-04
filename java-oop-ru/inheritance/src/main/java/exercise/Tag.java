package exercise;

import java.util.stream.Collectors;
import java.util.Map;

public abstract class Tag {
    private String tagName;
    private Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    protected String renderAttributes() {
        if (attributes.isEmpty()) {
            return "";
        }
        return attributes.entrySet()
                .stream()
                .map(entry -> String.format("%s=\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" ", " ", ""));
    }
    @Override
    public abstract String toString();
}
