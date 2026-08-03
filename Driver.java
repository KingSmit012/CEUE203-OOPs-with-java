import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {
        String logs[]={
            "10:05 alice Hello there",
            "10:06 bob",
            "10:07 charlie Just testing out the chat",
            "11:00 Dolly Hii , How are you?",
            "12:00 Elie How are you?"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Keyword: ");
        String KW = sc.nextLine();

        String result = chatFilter.FilterLogs(logs, KW);
        System.out.println(result);

        sc.close();
    }
}
