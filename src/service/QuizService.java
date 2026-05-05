package service;

import model.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizService {
    private static final String QUESTIONS_FILE = "data/questions.txt";

    public static List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        List<String> lines = FileService.readLines(QUESTIONS_FILE);
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if(parts.length == 8) {
                String[] options = new String[]{parts[1], parts[2], parts[3], parts[4]};
                int corrIdx = Integer.parseInt(parts[5]);
                questions.add(new Question(parts[0], options, corrIdx, parts[6], parts[7]));
            }
        }
        return questions;
    }

    public static List<Question> getQuizSubset(int amount, String difficulty, String category) {
        List<Question> all = getAllQuestions();
        List<Question> filtered = new ArrayList<>();
        
        for (Question q : all) {
            boolean diffMatch = difficulty.equals("Any") || q.getDifficulty().equalsIgnoreCase(difficulty);
            boolean catMatch = category.equals("Any") || q.getCategory().equalsIgnoreCase(category);
            if (diffMatch && catMatch) {
                filtered.add(q);
            }
        }
        
        Collections.shuffle(filtered);
        List<Question> result = new ArrayList<>();
        for (int i = 0; i < Math.min(amount, filtered.size()); i++) {
            Question q = filtered.get(i);
            q.shuffleOptions();
            result.add(q);
        }
        return result;
    }

    public static void saveQuestion(Question q) {
        FileService.appendLine(QUESTIONS_FILE, q.toString());
    }

    public static void updateAllQuestions(List<Question> questions) {
        List<String> lines = new ArrayList<>();
        for (Question q : questions) {
            lines.add(q.toString());
        }
        FileService.writeLines(QUESTIONS_FILE, lines);
    }
}
