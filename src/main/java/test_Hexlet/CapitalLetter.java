package test_Hexlet;

public class CapitalLetter {
    public static void main(String[] args) {
        var name = "СловООаывОО";

        // BEGIN (write your solution here)
        var name1 = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
        System.out.println(name1);
    }
}
