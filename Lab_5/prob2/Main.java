package prob2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = Arrays.asList(new Circle(5), new Rectangle(4, 6), new Triangle(5, 8));
        double sumOfArea = 0;
        for (Figure figure : figures) {
            sumOfArea += figure.computeArea();
        }
        System.out.println("SUM OF AREAS = " + sumOfArea);
    }
}
