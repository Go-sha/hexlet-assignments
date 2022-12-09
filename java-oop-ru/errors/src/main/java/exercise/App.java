package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            int dti = (int) circle.getSquare();
            if (circle.getSquare() - dti > 0.5) {
                dti++;
            }
            System.out.println(dti);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
