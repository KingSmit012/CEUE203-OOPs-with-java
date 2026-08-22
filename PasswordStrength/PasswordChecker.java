package PasswordStrength;

public class PasswordChecker {

    public static String strength(String pass) {

        int count = 0;

        if (pass.length() >= 8) {
            count++;
        }
        if (pass.matches(".*[A-Z].*")) {
            count++;
        }
        if (pass.matches(".*[0-9].*")) {
            count++;
        }
        if (pass.matches(".*[^a-zA-Z0-9].*")) {
            count++;
        }
        // 0-1 Weak, 2-3 Medium, 4 Strong
        if (count <= 1) {
            return "Weak";
        } else if (count <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}