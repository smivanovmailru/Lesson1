package lesson1;

import java.util.Scanner;
/*Написать метод, который будет просить вводить пользователя с клавиатуры числа
и будет считывать их и склеивать в одно предложение до тех пор,
пока пользователь не введет с клавитуры слово STOP.
Все слова введенные до этого должны отобразится в консоли
одним предложением.*/
public class WordStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder numbers = new StringBuilder();

        System.out.println("Введите значение. Для завершения работы введите \"STOP\"");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("STOP")) {
                break;
            }

            if (numbers.length() != 0) {
               numbers.append(" ");
            }
            numbers.append(input);
        }

            System.out.println("Введены: ");
            System.out.println(numbers.toString());
            scanner.close();
            }
    }