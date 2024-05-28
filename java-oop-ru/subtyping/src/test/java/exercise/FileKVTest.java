package exercise;

// BEGIN
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
// END


class FileKVTest {
    @Test
    void testFileKV() {
        String filePath = "src/test/resources/file";
        Map<String, String> initialData = Map.of("key1", "value1", "key2", "value2");
        KeyValueStorage storage = new FileKV(filePath, initialData);

        assertThat(storage.get("key1", "default")).isEqualTo("value1");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");

        storage.set("key3", "value3");
        assertThat(storage.get("key3", "default")).isEqualTo("value3");

        storage.unset("key1");
        assertThat(storage.get("key1", "default")).isEqualTo("default");

        Map<String, String> expected = Map.of("key2", "value2", "key3", "value3");
        assertThat(storage.toMap()).isEqualTo(expected);
    }
}
    // END
