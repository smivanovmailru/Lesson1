package lesson1;
import java.util.Scanner;
import java.util.Random;


/*Написать метод, принимающий в аргументы одномерный массив и возвращающий true, если после ввода с
клавиатуры пользователем числа, данное число присутствует в массиве. Программа показывает есть ли такое число в созданном
до этого массиве.

Написать второй метод, который в аргументы принимает переменную типа int,
этот метод возвращает массив размерностью аргумента этого метода, а сам массив должен быть
заполнен случайными числами от -50 до +50.

Вызвать второй метод в аргументах первого метода внутри тела метода main.*/

public class Arrays {
    public static boolean numberInArray(int[] array, int value) {
        for (int value1 : array) {
            if (value1 == value) {
                return true;
            }
        }
        return false;
    }
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] massiv = new int[size];
        for (int i = 0; i < size; i++) {
            massiv[i] = random.nextInt(100) - 50;
        }
        return massiv;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = scanner.nextInt();
        int[] array = randomArray(size);

        System.out.print("Проверяемое значение: ");
        int numberToCheck = scanner.nextInt();

        // Проверка наличия числа в массиве
        boolean isPresent = numberInArray(array, numberToCheck); // не уверен, что это является вызовом второго метода внутри аргументов первого, но по другому не сумел.

        // Вывод результата
        if (isPresent) {
            System.out.println(numberToCheck + " присутствует");
        } else {
            System.out.println(numberToCheck + " отсутствует");
        }

        scanner.close();
    }
}