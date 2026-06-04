package Utility;

public class DataGenerator {

    public static String generateEmail() {
        return "user" + System.currentTimeMillis() + "@gmail.com";
    }
}