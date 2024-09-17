package lesson1;
import java.util.Scanner;
import java.util.Random;

/*Написать метод с названием cathTheNumber().
Внутри метода генерируется случайное число в диапазоне от 0 до 100.
Программа прочить ввести имя пользователя {name}.
Пользователю предлагают через консоль угадать данное число.
Этот процесс происходит в бесконечном цикле.
Если пользователь ввел число больше, чем загаданное. То в консоль выводится сообщение:
"Ваше число слишком большое. Попробуйте еще раз!".
Если пользователь ввел число меньше, чем загаданное. То в консоль выводится сообщение:
"Ваше число слишком маленькое. Попробуйте еще раз!".
Если пользователь угадал число. То в консоль выводится сообщение:
"Поздравляю, {name}. Игра окончена!".
На этом выполнение программы заканчивается.*/

public class Game {
    public static void catchtheNumber(int number){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomValue = random.nextInt(100);

        System.out.println("Ваше имя?");
        String name = scanner.nextLine();

        int guessedValue = 1;

        while (guessedValue != randomValue){
            System.out.println("Угадай число!");

            if (scanner.hasNextLine()){
                guessedValue = scanner.nextInt();
                if (guessedValue < randomValue) {
                    System.out.println("Мало");
                }
                else if (guessedValue > randomValue){
                    System.out.println("Много");
                }
            }
            else {
                System.out.println("Попробуй еще раз");
                scanner.next();
            }
        }
        System.out.println("Малаца," + name);
scanner.close();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100);
        catchtheNumber(number);

    }
}
