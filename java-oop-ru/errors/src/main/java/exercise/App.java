package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            double square = circle.getSquare();
            System.out.println(Math.round(square));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }

    public static void main(String[] args) {
        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 4);
        App.printSquare(circle);  // => "50" "Вычисление окончено"

        Circle circle1 = new Circle(point, -2);
        App.printSquare(circle1);  // => "Не удалось посчитать площадь" "Вычисление окончено"
    }
}

// END
