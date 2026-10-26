import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        String[] logins = {
            "Aman" , "Baman" , "Chaman" , "Smit" ,
            "Hetvi" , "Daman" , "Smit" , "Hetvi" , "Chaman"
        };

        HashSet<String> uniqueUsers = new HashSet<>();
        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        for (String name : logins) {
            uniqueUsers.add(name);
            orderedUsers.add(name);
        }

        System.out.println("Unique visitors: " + uniqueUsers.size());
        System.out.println("First three distinct names:");

        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}
