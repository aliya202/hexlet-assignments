package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalData = storage.toMap();

        for (String key : originalData.keySet()) {
            storage.unset(key);
        }

        for (Map.Entry<String, String> entry : originalData.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
