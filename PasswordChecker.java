import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Password : ");
        String pass = sc.nextLine();
        int count =0;

        if(pass.length() >= 8){
            count++;
        }
        if(pass.matches(".*[A-Z].*")){
            count++;
        }
        if(pass.matches(".*[0-9].*")){
            count++;
        }
        if (pass.matches(".*[^a-zA-Z0-9].*"))
            count++;

        if (count < 1)
            System.out.println("Weak");
        else if (count <= 2)
            System.out.println("Medium");
        else
            System.out.println("Strong");
    }
}
