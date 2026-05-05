package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String text;
    private String[] options; // Assumes 4 options
    private int correctOptionIndex; // 0-based index
    private String difficulty; // Easy, Medium, Hard
    private String category; // e.g. "OOP"

    public Question(String text, String[] options, int correctOptionIndex, String difficulty, String category) {
        this.text = text;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.difficulty = difficulty;
        this.category = category;
    }

    public String getText() { return text; }
    public String[] getOptions() { return options; }
    public int getCorrectOptionIndex() { return correctOptionIndex; }
    public String getDifficulty() { return difficulty; }
    public String getCategory() { return category; }

    public void setCorrectOptionIndex(int idx) { this.correctOptionIndex = idx; }

    // Shuffles options and safely tracks where the correct answer ended up
    public void shuffleOptions() {
        if (options == null || options.length == 0) return;
        
        List<String> list = new ArrayList<>();
        String correctAns = options[correctOptionIndex];
        
        Collections.addAll(list, options);
        Collections.shuffle(list);
        
        for (int i = 0; i < options.length; i++) {
            options[i] = list.get(i);
            if (options[i].equals(correctAns)) {
                correctOptionIndex = i;
            }
        }
    }
    
    @Override
    public String toString() {
        return text + "|" + options[0] + "|" + options[1] + "|" + options[2] + "|" + options[3] + "|" + correctOptionIndex + "|" + difficulty + "|" + category;
    }
}
