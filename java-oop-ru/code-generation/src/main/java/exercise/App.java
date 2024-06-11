package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        String jsonRepresentation = car.serialize();
        if (jsonRepresentation != null) {
            try {
                Files.writeString(path, jsonRepresentation);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Car extract(Path path) {
        try {
            String jsonRepresentation = Files.readString(path);
            return Car.unserialize(jsonRepresentation);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        User owner = new User(1, "Ivan", "P", 25);
        Car car1 = new Car(1, "audi", "q3", "black", owner);
        Path path1 = Path.of("/tmp/file1.json");

        App.save(path1, car1);

        Car car2 = App.extract(Path.of("/tmp/file2.json"));
        if (car2 != null) {
            System.out.println(car2.getModel());
        }
    }
}
// END
