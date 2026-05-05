package service;

import model.QuizResult;
import java.util.ArrayList;
import java.util.List;

public class LeaderboardService {
    private static final String LEADERBOARD_FILE = "data/leaderboard.txt";

    public static void saveResult(QuizResult result) {
        if(!"admin".equals(result.getUsername())) {
             FileService.appendLine(LEADERBOARD_FILE, result.toString());
        }
    }

    public static List<QuizResult> getTopScores(int limit) {
        List<QuizResult> results = new ArrayList<>();
        List<String> lines = FileService.readLines(LEADERBOARD_FILE);
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 4) {
                results.add(new QuizResult(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
            }
        }
        
        results.sort((r1, r2) -> {
            double p1 = r1.getPercentage();
            double p2 = r2.getPercentage();
            if (p1 != p2) {
                return Double.compare(p2, p1);
            }
            return Integer.compare(r1.getTimeTakenSeconds(), r2.getTimeTakenSeconds());
        });

        return results.subList(0, Math.min(limit, results.size()));
    }
}
