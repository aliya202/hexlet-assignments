package exercise.dto.articles;

import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildArticlePage {
    private Map<String, ? extends ValidationError<?>> errors;
    private String title;
    private String content;
}
