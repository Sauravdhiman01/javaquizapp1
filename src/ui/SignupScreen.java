package ui;

import service.AuthService;
import util.ThemeUtil;

import javax.swing.*;
import java.awt.*;

public class SignupScreen extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public SignupScreen() {
        setTitle("Java Quiz App - Signup");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        centerPanel.add(new JLabel("New Username:"));
        userField = new JTextField();
        centerPanel.add(userField);

        centerPanel.add(new JLabel("New Password:"));
        passField = new JPasswordField();
        centerPanel.add(passField);

        JButton signupBtn = new JButton("Register");
        signupBtn.setBackground(ThemeUtil.getPrimaryColor());
        signupBtn.setForeground(Color.WHITE);
        signupBtn.addActionListener(e -> attemptSignup());
        
        JButton backBtn = new JButton("Back to Login");
        backBtn.addActionListener(e -> {
            new LoginScreen().setVisible(true);
            dispose();
        });

        centerPanel.add(signupBtn);
        centerPanel.add(backBtn);
        
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
        } catch(Exception e) {}

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        ThemeUtil.applyTheme(this);
    }

    private void attemptSignup() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        
        if (user.trim().isEmpty() || pass.trim().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Fields cannot be empty.");
             return;
        }

        String result = AuthService.register(user, pass);
        if ("SUCCESS".equals(result)) {
            JOptionPane.showMessageDialog(this, "Registration Successful! Please login.");
            new LoginScreen().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, result, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
