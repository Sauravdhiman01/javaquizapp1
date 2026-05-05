package model;

public class QuizResult {
    private String username;
    private int score;
    private int totalQuestions;
    private int timeTakenSeconds;

    public QuizResult(String username, int score, int totalQuestions, int timeTakenSeconds) {
        this.username = username;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.timeTakenSeconds = timeTakenSeconds;
    }

    public String getUsername() { return username; }
    public int getScore() { return score; }
    public int getTotalQuestions() { return totalQuestions; }
    public int getTimeTakenSeconds() { return timeTakenSeconds; }

    public double getPercentage() {
        if (totalQuestions == 0) return 0;
        return ((double) score / totalQuestions) * 100;
    }
    
    public String getStatus() {
        return getPercentage() >= 50.0 ? "Pass" : "Fail";
    }
    
    @Override
    public String toString() {
        return username + "|" + score + "|" + totalQuestions + "|" + timeTakenSeconds;
    }
}
