package ui;

import service.AuthService;
import util.ThemeUtil;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public LoginScreen() {
        setTitle("Java Quiz App - Login");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        centerPanel.add(new JLabel("Username:"));
        userField = new JTextField();
        centerPanel.add(userField);

        centerPanel.add(new JLabel("Password:"));
        passField = new JPasswordField();
        centerPanel.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(ThemeUtil.getPrimaryColor());
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(e -> attemptLogin());
        
        JButton signupBtn = new JButton("Go to Signup");
        signupBtn.addActionListener(e -> {
            new SignupScreen().setVisible(true);
            dispose();
        });

        centerPanel.add(loginBtn);
        centerPanel.add(signupBtn);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton themeBtn = new JButton("Toggle Theme");
        themeBtn.addActionListener(e -> ThemeUtil.toggleTheme(this));
        topPanel.add(themeBtn);

        try {
            ImageIcon icon = new ImageIcon("assets/login_hero.png");
            Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            add(imageLabel, BorderLayout.WEST);
        } catch(Exception e) {
            e.printStackTrace();
        }

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        ThemeUtil.applyTheme(this);
    }

    private void attemptLogin() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        
        if (AuthService.login(user, pass)) {
            if ("admin".equals(user)) {
                new AdminPanel().setVisible(true);
            } else {
                new QuizScreen(user).setVisible(true);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
