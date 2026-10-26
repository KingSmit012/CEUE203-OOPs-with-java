
import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Aman", 70);
        scores.put("Baman", 80);
        scores.put("Chaman", 90);
        scores.put("Smit", 95);
        scores.put("Hetvi", 95);

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());

            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }

            return result;
        });

        int topN = 3;

        System.out.println("Leaderboard:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                    player.getKey() + " : " + player.getValue());
        }
    }
}
