package ui;

import model.Question;
import model.QuizResult;
import service.LeaderboardService;
import util.ThemeUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ResultScreen extends JFrame {
    public ResultScreen(QuizResult result, List<Question> questions, int[] userAnswers) {
        LeaderboardService.saveResult(result);
        
        setTitle("Quiz Results - " + result.getUsername());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new GridLayout(3, 1));
        JLabel scoreLabel = new JLabel("Score: " + result.getScore() + " / " + result.getTotalQuestions(), SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel statLabel = new JLabel(String.format("Percentage: %.2f%% | Time: %ds | Status: %s", 
            result.getPercentage(), result.getTimeTakenSeconds(), result.getStatus()), SwingConstants.CENTER);
        statLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton homeBtn = new JButton("Home / New Quiz");
        homeBtn.addActionListener(e -> {
            new QuizScreen(result.getUsername()).setVisible(true);
            dispose();
        });
        
        JButton themeBtn = new JButton("Toggle Theme");
        themeBtn.addActionListener(e -> ThemeUtil.toggleTheme(this));
        
        btnPanel.add(homeBtn);
        btnPanel.add(themeBtn);
        
        topPanel.add(scoreLabel);
        topPanel.add(statLabel);
        topPanel.add(btnPanel);
        add(topPanel, BorderLayout.NORTH);
        
        // Review System
        JPanel reviewPanel = new JPanel();
        reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            int uAns = userAnswers[i];
            
            JPanel qPanel = new JPanel(new GridLayout(3, 1));
            qPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            qPanel.add(new JLabel("Q" + (i+1) + ": " + q.getText()));
            
            JLabel correctAnsLbl = new JLabel("Correct Answer: " + q.getOptions()[q.getCorrectOptionIndex()]);
            correctAnsLbl.setForeground(new Color(0, 128, 0)); // Green
            qPanel.add(correctAnsLbl);
            
            String uAnsText = (uAns >= 0 && uAns < 4) ? q.getOptions()[uAns] : "No Answer";
            JLabel userAnsLbl = new JLabel("Your Answer: " + uAnsText);
            
            if (uAns == q.getCorrectOptionIndex()) {
                userAnsLbl.setForeground(new Color(0, 128, 0)); // Green
            } else {
                userAnsLbl.setForeground(Color.RED);
            }
            qPanel.add(userAnsLbl);
            
            reviewPanel.add(qPanel);
            reviewPanel.add(new JSeparator());
        }
        
        JScrollPane scroll = new JScrollPane(reviewPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
        
        ThemeUtil.applyTheme(this);
    }
}
