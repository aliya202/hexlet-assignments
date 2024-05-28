package exercise;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    String path;

    public FileKV(String filePath, Map<String, String> initialStorage) {
        this.path = filePath;
        String serializedData = Utils.serialize(initialStorage);
        Utils.writeFile(filePath, serializedData);
    }
    @Override
    public void set(String key, String value) {
        Map<String, String> currentData = Utils.unserialize(Utils.readFile(path));
        currentData.put(key, value);
        Utils.writeFile(path, Utils.serialize(currentData));
    }

    @Override
    public void unset(String key) {
        Map<String, String> currentData = Utils.unserialize(Utils.readFile(path));
        currentData.remove(key);
        Utils.writeFile(path, Utils.serialize(currentData));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> currentData = Utils.unserialize(Utils.readFile(path));
        return currentData.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(path));
    }
}
