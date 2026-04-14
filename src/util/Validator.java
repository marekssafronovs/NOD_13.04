package util;

public class Validator {

    public static boolean notEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Lauks nedrīkst būt tukšs!");
            return false;
        }
        return true;
    }
}