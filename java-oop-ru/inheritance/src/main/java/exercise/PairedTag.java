package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String attributes = renderAttributes();
        String childrenString = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        return String.format("<%s%s>%s%s</%s>", getTagName(), attributes, body, childrenString, getTagName());
    }
}
