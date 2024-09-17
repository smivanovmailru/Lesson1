package lesson1;

/*Написать перегруженный метод, который может:
•	Не принимать никаких значений, тогда он будет выводить на консоль сообщение типа: "Я пустой".
•	Принимать в качестве параметров String, тогда он будет выводить на консоль это сообщение.
•	Принимать в качестве параметров массив строк, тогда он будет выводить на консоль все его значения через пробел.
•	Принимать в качестве параметра массив чисел, тогда он будет выводить на консоль сумму элементов массива.
•	Принимать в качестве параметров число и строку, тогда он будет выводить на консоль сообщение типа: "Ваше сообщение - "%%%%%%%%", ваше число -  $",
         где "%%%%%%%%" и $ ваши введенные строка и число соответственно.*/

import java.util.Arrays;

public class OverloadedMethod {
    public static void main(String[] args) {
        Method();
    }
    public static void Method() {
        System.out.println("Я пустой");
    }

    public static void Method(String text) {
        System.out.println(text);
    }

    public static void Method(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (i < array.length - 1) {
                System.out.println(" ");
            }
        }
    }

    public static void Method(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        System.out.println(sum);
    }
    public static void Method(int value, String text){
        System.out.println("Ваше сообщение - " + text + ", ваше число - " + value);
    };

}
