package lesson1;
import java.util.Scanner;


public class PalindromCheck {

    public static boolean isPalindrom(String value) {
        StringBuilder reverse = new StringBuilder(value).reverse();
        return value.equals(reverse.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value:");
        String data = scanner.nextLine();
        
        if (isPalindrom(data)) {
            System.out.println(data + " pal");
        } else {
            System.out.println(data + " nepal");
        }
        scanner.close();
        }
    }
