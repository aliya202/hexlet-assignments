package exercise;

import java.util.Locale;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;
    double resultArea;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        resultArea = area + balconyArea;
        return resultArea;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Квартира площадью %.1f метров на %d этаже", getArea(), floor);
    }

    @Override
    public double compareTo(Home another) {
        double thisArea = this.getArea();
        double anotherArea = another.getArea();

        if (thisArea > anotherArea) {
            return 1;
        } else if (thisArea < anotherArea) {
            return -1;
        } else {
            return 0;
        }
    }
}
// END
