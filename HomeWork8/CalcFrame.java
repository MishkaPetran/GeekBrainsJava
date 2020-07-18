import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame {
    public CalcFrame(){
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 320, 480);
        setResizable(false);
        setVisible(true);

        JTextField textField = new JTextField();
        textField.setBounds(10,10, 290,50);
        add(textField);

        JButton[] jButtons = new JButton[10];
        setLayout(null);
        int buttonWidth = 40;
        int buttonHeight = 40;
        int startValueX = 10;
        int startValueY = 70;

        for (int i = 0; i < jButtons.length; i++) {
            for (int j = 0; j < 3; j++) {
                jButtons[i] = new JButton(String.valueOf(i));
                jButtons[i].setBounds(startValueX, startValueY, buttonWidth, buttonHeight);
                add(jButtons[i]);
            }



        }

    }
}
