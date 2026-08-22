package PasswordStrength;

public class driver{

    public static void main(String[] args) {

        String [] passwords = {
            "abc",
            "abcd1234",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String p : passwords) {
            System.out.println("Password  : " + p);

            System.out.println("Length >= 8 : " + (p.length() >= 8));
            System.out.println("Uppercase : " + p.matches(".*[A-Z].*"));
            System.out.println("Digit : " + p.matches(".*[0-9].*"));
            System.out.println("Special Character : " + p.matches(".*[^a-zA-Z0-9].*"));

            System.out.println("Strength : " + PasswordChecker.strength(p));

            System.out.println();
        }
    }
}