package lesson3;
import org.testng.annotations.Test;

import java.util.regex.*;

public class RegExample {
    @Test

    public static void regularExtensions() {

        String text = "Hello, World!";
        String regex = "[a-z A-Z,]+ [ a-z A-Z!]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Обнаружено: " + matcher.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String email = "mailto:example@example.com";
        String regex1 = "[a-zA-Z0-9.,-_]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";

        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(email);

        if (matcher1.find()) {
            System.out.println("Обнаружено: " + matcher1.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String date = "01-01-2022";
        String regex2 = "\\d{2}-\\d{2}-\\d{4}";

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(date);

        if (matcher2.find()) {
            System.out.println("Обнаружено: " + matcher2.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String phoneNumber = "+1 (555) 123-4567";
        String regex3 = "\\+?\\d{1,3}[-.\\s]?\\(?\\d{1,4}?\\)[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}";

        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(phoneNumber);

        if (matcher3.find()) {
            System.out.println("Обнаружено: " + matcher3.group());
        } else {
            System.out.println("Не обнаружено");
        }
        System.out.println("____________________________");


        String picture = "image.jpg";
        String regex4 = ".*\\.(jpg|png|gif)$";

        Pattern pattern4 = Pattern.compile(regex4);
        Matcher matcher4 = pattern4.matcher(picture);

        if (matcher4.find()) {
            System.out.println("Обнаружено: " + matcher4.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String ip = "192.168.1.1";
        String regex5 = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern pattern5 = Pattern.compile(regex5);
        Matcher matcher5 = pattern5.matcher(ip);

        if (matcher5.find()) {
            System.out.println("Обнаружено: " + matcher5.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String variousSymbols = "Abc123#";
        String regex6 = "^[A-Za-z0-9#*/.,<>&%]+$";

        Pattern pattern6 = Pattern.compile(regex6);
        Matcher matcher6 = pattern6.matcher(variousSymbols);

        if (matcher6.find()) {
            System.out.println("Обнаружено: " + matcher6.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String time = "12:30";
        String regex7 = "^([01]?\\d|[21-23]+):([0-59]+)$";

        Pattern pattern7 = Pattern.compile(regex7);
        Matcher matcher7 = pattern7.matcher(time);

        if (matcher7.find()) {
            System.out.println("Обнаружено: " + matcher7.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String HEX = "#FF0000";
        String regex8 = "#([A-Fa-f0-9]{6})";

        Pattern pattern8 = Pattern.compile(regex8);
        Matcher matcher8 = pattern8.matcher(HEX);

        if (matcher8.find()) {
            System.out.println("Обнаружено: " + matcher8.group());
        } else {
            System.out.println("Не обнаружено.");
        }
        System.out.println("____________________________");


        String URL = "http://www.example.com";
        String regex9 = "(http)?s?(://www)?\\.?[A-Za-z0-9]+\\.[a-zA-Z]{2,}";

        Pattern pattern9 = Pattern.compile(regex9);
        Matcher matcher9 = pattern9.matcher(URL);

        if (matcher9.find()) {
            System.out.println("Обнаружено: " + matcher9.group());
        } else {
            System.out.println("Не обнаружено.");
        }

    }
}

