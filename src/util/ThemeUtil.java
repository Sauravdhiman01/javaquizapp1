package util;

import javax.swing.*;
import java.awt.*;

public class ThemeUtil {
    public enum Theme { LIGHT, DARK }
    public static Theme currentTheme = Theme.LIGHT;

    public static void toggleTheme(JFrame frame) {
        currentTheme = (currentTheme == Theme.LIGHT) ? Theme.DARK : Theme.LIGHT;
        applyTheme(frame);
    }

    public static void applyTheme(Component c) {
        boolean isDark = (currentTheme == Theme.DARK);
        Color bgColor = isDark ? new Color(30, 30, 30) : new Color(245, 245, 245);
        Color fgColor = isDark ? Color.WHITE : Color.BLACK;
        Color panelColor = isDark ? new Color(45, 45, 45) : Color.WHITE;
        Color defaultBtnBg = isDark ? new Color(70, 70, 70) : new Color(220, 220, 220);
        Color defaultBtnFg = isDark ? Color.WHITE : Color.BLACK;

        if (c instanceof JFrame) {
            ((JFrame) c).getContentPane().setBackground(bgColor);
        } else if (c instanceof JPanel) {
            c.setBackground(panelColor);
        } else if (c instanceof JButton) {
            JButton btn = (JButton) c;
            Color btnBg = btn.getBackground();
            // Assign explicitly default background if it looks generic
            if (btnBg == null || btnBg.equals(UIManager.getColor("Button.background")) || btnBg.equals(new Color(70,70,70)) || btnBg.equals(new Color(220,220,220))) {
                btn.setBackground(defaultBtnBg);
                btn.setForeground(defaultBtnFg);
                btn.setOpaque(true);
            }
        } else if (c instanceof JRadioButton || c instanceof JCheckBox) {
            c.setBackground(panelColor);
            c.setForeground(fgColor);
        } else if (!(c instanceof JComboBox || c instanceof JTextField || c instanceof JProgressBar)) {
            c.setBackground(bgColor);
            c.setForeground(fgColor);
        }

        if (c instanceof Container) {
            for (Component comp : ((Container) c).getComponents()) {
                applyTheme(comp);
            }
            if (c instanceof JComponent) {
                ((JComponent) c).revalidate();
                ((JComponent) c).repaint();
            }
        }
    }
    
    public static Color getPrimaryColor() {
        return new Color(0, 122, 255); // Nice action blue
    }
    
    public static Color getSecondaryColor() {
        return (currentTheme == Theme.DARK) ? new Color(70, 70, 70) : new Color(220, 220, 220);
    }
}
