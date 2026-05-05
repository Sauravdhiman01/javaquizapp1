package ui;

import model.Question;
import model.QuizResult;
import service.QuizService;
import util.ThemeUtil;
import util.TimerUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class QuizScreen extends JFrame {
    private String username;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int[] userAnswers;
    private int timeTaken = 0;
    
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup bg;
    private JButton nextBtn, submitBtn;
    private JLabel timerLabel;
    private JProgressBar progressBar;
    
    private TimerUtil timerUtil;

    public QuizScreen(String username) {
        this.username = username;
        setupConfigScreen();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmExit();
            }
        });
    }
    
    private void confirmExit() {
        int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit? Your progress will be lost.", "Exit", JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void setupConfigScreen() {
        setTitle("Quiz Settings - " + username);
        setSize(700, 400);
        setLocationRelativeTo(null);
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel p = new JPanel(new GridLayout(4, 2, 10, 20));
        p.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        p.add(new JLabel("Number of Questions:"));
        JComboBox<Integer> countBox = new JComboBox<>(new Integer[]{5, 10, 15, 20});
        p.add(countBox);
        
        p.add(new JLabel("Difficulty:"));
        JComboBox<String> diffBox = new JComboBox<>(new String[]{"Any", "Easy", "Medium", "Hard"});
        p.add(diffBox);
        
        p.add(new JLabel("Category:"));
        JComboBox<String> catBox = new JComboBox<>(new String[]{"Any", "Java Basics", "OOP", "Collections", "Threads", "Exception Handling"});
        p.add(catBox);
        
        JButton startBtn = new JButton("Start Quiz");
        startBtn.setBackground(ThemeUtil.getPrimaryColor());
        startBtn.setForeground(Color.WHITE);
        startBtn.addActionListener(e -> {
            int count = (Integer) countBox.getSelectedItem();
            String diff = (String) diffBox.getSelectedItem();
            String cat = (String) catBox.getSelectedItem();
            
            questions = QuizService.getQuizSubset(count, diff, cat);
            if (questions.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Not enough questions in this category/difficulty.");
                return;
            }
            userAnswers = new int[questions.size()];
            for(int i=0; i<userAnswers.length; i++) userAnswers[i] = -1;
            
            initQuizUI();
        });
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton themeBtn = new JButton("Toggle Theme");
        themeBtn.addActionListener(e -> ThemeUtil.toggleTheme(this));
        
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            dispose();
        });
        
        topPanel.add(themeBtn);
        topPanel.add(logoutBtn);
        
        try {
            ImageIcon icon = new ImageIcon("assets/quiz_hero.png");
            Image scaledImage = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            JLabel imgLbl = new JLabel(new ImageIcon(scaledImage));
            imgLbl.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            add(imgLbl, BorderLayout.WEST);
        } catch(Exception ex) {}

        add(topPanel, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        
        JPanel bot = new JPanel();
        bot.add(startBtn);
        add(bot, BorderLayout.SOUTH);
        
        ThemeUtil.applyTheme(this);
        revalidate();
        repaint();
    }
    
    private void initQuizUI() {
        setTitle("Quiz - " + username);
        setSize(950, 600);
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new BorderLayout());
        progressBar = new JProgressBar(0, questions.size());
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        topPanel.add(progressBar, BorderLayout.SOUTH);
        
        JPanel topRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        timerLabel = new JLabel("Time: 0");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topRight.add(timerLabel);
        
        JButton themeBtn = new JButton("Toggle Theme");
        themeBtn.addActionListener(e -> ThemeUtil.toggleTheme(this));
        topRight.add(themeBtn);
        
        topPanel.add(topRight, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        questionLabel = new JLabel("");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.add(questionLabel, BorderLayout.NORTH);
        
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));
        // Add subtle title to options area
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        optionButtons = new JRadioButton[4];
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 16));
            bg.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        centerPanel.add(optionsPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        
        try {
            ImageIcon quizIcon = new ImageIcon("assets/quiz_hero.png");
            Image quizScaled = quizIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel quizImgLbl = new JLabel(new ImageIcon(quizScaled));
            quizImgLbl.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
            add(quizImgLbl, BorderLayout.EAST);
        } catch(Exception ex) {}
        
        JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        nextBtn = new JButton("Next");
        submitBtn = new JButton("Submit Quiz");
        submitBtn.setBackground(new Color(40, 167, 69));
        submitBtn.setForeground(Color.WHITE);
        
        nextBtn.addActionListener(e -> navigate(1));
        submitBtn.addActionListener(e -> {
            if(JOptionPane.showConfirmDialog(this,"Are you sure you want to submit?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                finishQuiz();
            }
        });
        
        botPanel.add(nextBtn);
        botPanel.add(submitBtn);
        add(botPanel, BorderLayout.SOUTH);
        
        timerUtil = new TimerUtil(60, () -> {
            timeTaken++;
            timerLabel.setText("Time Left: " + timerUtil.getTimeLeft() + "s");
        }, () -> {
            navigate(1);
        });
        timerUtil.start();
        
        loadQuestion();
        ThemeUtil.applyTheme(this);
        revalidate();
        repaint();
    }
    
    private void saveAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                userAnswers[currentQuestionIndex] = i;
                break;
            }
        }
    }
    
    private void navigate(int dir) {
        saveAnswer();
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex += dir;
            loadQuestion();
        } else {
            finishQuiz();
        }
    }
    
    private void loadQuestion() {
        if (timerUtil != null) {
            timerUtil.stop();
            timerUtil.setTimeLeft(60);
            timerUtil.start();
        }
        
        Question q = questions.get(currentQuestionIndex);
        questionLabel.setText("<html>Q" + (currentQuestionIndex+1) + ": " + q.getText() + "</html>");
        
        bg.clearSelection();
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(q.getOptions()[i]);
            if (userAnswers[currentQuestionIndex] == i) {
                optionButtons[i].setSelected(true);
            }
        }
        
        nextBtn.setEnabled(currentQuestionIndex < questions.size() - 1);
        progressBar.setValue(currentQuestionIndex + 1);
    }
    
    private void finishQuiz() {
        if(timerUtil != null) timerUtil.stop();
        saveAnswer();
        
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (userAnswers[i] == questions.get(i).getCorrectOptionIndex()) {
                score++;
            }
        }
        
        QuizResult result = new QuizResult(username, score, questions.size(), timeTaken);
        new ResultScreen(result, questions, userAnswers).setVisible(true);
        dispose();
    }
}
