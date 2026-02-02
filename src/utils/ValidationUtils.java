package utils;

public class ValidationUtils {
    public static boolean isValidId(String id){
        return id.matches("P\\d{3}");
    }

    public static boolean isNotEmpty(String text){
        return text != null && !text.isEmpty();
    }
}
