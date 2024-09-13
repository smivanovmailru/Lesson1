package lesson1;
import java.util.Scanner;
import java.time.Year;

public class DateOfBirth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int currentYear = Year.now().getValue();
        System.out.println("Ваш возраст " + (currentYear - year));
    }

    public static class WordStop {
    }
}
