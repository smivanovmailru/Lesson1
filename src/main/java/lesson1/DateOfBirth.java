package lesson1;
import java.util.Scanner;
import java.time.Year;
/*Написать метод, который просит чтобы пользователь
ввел с клавиатуры свой год рождения.
После данного действия в консоль выводится информация о его возрасте.*/
public class DateOfBirth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год Вашего Рождения:");
        int yearOfBirth = scanner.nextInt();
        int currentYear = Year.now().getValue();
        int age = currentYear - yearOfBirth;
        if (age < 38) {
            System.out.println("Тебе " + age + " лет! ... Малолетка! Ха ха ха");
        } else {
            System.out.println("Ваш возраст " + age + " лет, достопочтенный старец!");
        }
    }
}
