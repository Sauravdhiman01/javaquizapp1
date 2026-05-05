package ui;

import model.Question;
import service.LeaderboardService;
import service.QuizService;
import model.QuizResult;
import util.ThemeUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminPanel extends JFrame {
    private DefaultListModel<Question> listModel;
    private JList<Question> questionList;
    
    public AdminPanel() {
        setTitle("Admin Panel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton viewLbBtn = new JButton("View Leaderboard");
        viewLbBtn.addActionListener(e -> viewLeaderboard());
        JButton themeBtn = new JButton("Toggle Theme");
        themeBtn.addActionListener(e -> ThemeUtil.toggleTheme(this));
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            dispose();
        });
        
        topPanel.add(viewLbBtn);
        topPanel.add(themeBtn);
        topPanel.add(logoutBtn);
        add(topPanel, BorderLayout.NORTH);
        
        listModel = new DefaultListModel<>();
        refreshQuestionList();
        
        questionList = new JList<>(listModel);
        questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(questionList), BorderLayout.CENTER);
        
        JPanel botPanel = new JPanel();
        JButton addBtn = new JButton("Add Question");
        JButton editBtn = new JButton("Edit Question");
        JButton delBtn = new JButton("Delete Question");
        
        addBtn.addActionListener(e -> openQuestionDialog(null));
        editBtn.addActionListener(e -> {
            Question sel = questionList.getSelectedValue();
            if(sel != null) openQuestionDialog(sel);
        });
        delBtn.addActionListener(e -> {
            Question sel = questionList.getSelectedValue();
            if(sel != null) {
                List<Question> all = QuizService.getAllQuestions();
                all.removeIf(q -> q.getText().equals(sel.getText()));
                QuizService.updateAllQuestions(all);
                refreshQuestionList();
            }
        });
        
        botPanel.add(addBtn);
        botPanel.add(editBtn);
        botPanel.add(delBtn);
        add(botPanel, BorderLayout.SOUTH);
        
        ThemeUtil.applyTheme(this);
    }
    
    private void refreshQuestionList() {
        listModel.clear();
        for (Question q : QuizService.getAllQuestions()) {
            listModel.addElement(q);
        }
    }
    
    private void viewLeaderboard() {
        List<QuizResult> top = LeaderboardService.getTopScores(10);
        StringBuilder sb = new StringBuilder("Top 10 Scores:\n\n");
        for (int i=0; i<top.size(); i++) {
            QuizResult r = top.get(i);
            sb.append((i+1)).append(". ").append(r.getUsername())
              .append(" - Score: ").append(r.getScore()).append("/").append(r.getTotalQuestions())
              .append(" (").append(String.format("%.2f", r.getPercentage())).append("%)")
              .append(" - Time: ").append(r.getTimeTakenSeconds()).append("s\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Leaderboard", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void openQuestionDialog(Question q) {
        JDialog d = new JDialog(this, q == null ? "Add Question" : "Edit Question", true);
        d.setSize(400, 500);
        d.setLocationRelativeTo(this);
        d.setLayout(new GridLayout(9, 2, 5, 5));
        
        JTextField textF = new JTextField(q != null ? q.getText() : "");
        JTextField op1F = new JTextField(q != null ? q.getOptions()[0] : "");
        JTextField op2F = new JTextField(q != null ? q.getOptions()[1] : "");
        JTextField op3F = new JTextField(q != null ? q.getOptions()[2] : "");
        JTextField op4F = new JTextField(q != null ? q.getOptions()[3] : "");
        
        JComboBox<Integer> corrBox = new JComboBox<>(new Integer[]{0, 1, 2, 3});
        if(q != null) corrBox.setSelectedItem(q.getCorrectOptionIndex());
        
        JComboBox<String> diffBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        if(q != null) diffBox.setSelectedItem(q.getDifficulty());
        
        JComboBox<String> catBox = new JComboBox<>(new String[]{"Java Basics", "OOP", "Collections", "Threads", "Exception Handling"});
        if(q != null) catBox.setSelectedItem(q.getCategory());
        
        d.add(new JLabel("Question Text:")); d.add(textF);
        d.add(new JLabel("Option 0:")); d.add(op1F);
        d.add(new JLabel("Option 1:")); d.add(op2F);
        d.add(new JLabel("Option 2:")); d.add(op3F);
        d.add(new JLabel("Option 3:")); d.add(op4F);
        d.add(new JLabel("Correct Index (0-3):")); d.add(corrBox);
        d.add(new JLabel("Difficulty:")); d.add(diffBox);
        d.add(new JLabel("Category:")); d.add(catBox);
        
        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> {
            Question newQ = new Question(
                textF.getText(),
                new String[]{op1F.getText(), op2F.getText(), op3F.getText(), op4F.getText()},
                (Integer) corrBox.getSelectedItem(),
                (String) diffBox.getSelectedItem(),
                (String) catBox.getSelectedItem()
            );
            
            List<Question> all = QuizService.getAllQuestions();
            if (q != null) {
                for(int i=0; i<all.size(); i++) {
                    if (all.get(i).getText().equals(q.getText())) {
                        all.set(i, newQ);
                        break;
                    }
                }
                QuizService.updateAllQuestions(all);
            } else {
                QuizService.saveQuestion(newQ);
            }
            refreshQuestionList();
            d.dispose();
        });
        
        d.add(new JLabel()); d.add(saveBtn);
        d.setVisible(true);
    }
}
