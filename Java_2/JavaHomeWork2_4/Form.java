import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    public Form(String title){
        this.setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,480,600);

        JPanel chatPanel = new JPanel(new BorderLayout());
        JTextArea charTextArea = new JTextArea();
        charTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(charTextArea);
        chatPanel.add(scrollPane);
        add(chatPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());
        add(controlPanel, BorderLayout.SOUTH);

        JTextField inputField = new JTextField();
        controlPanel.add(inputField);
        inputField.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder(charTextArea.getText());

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!String.valueOf(inputField.getText()).trim().isEmpty()){
                    sb.append(charTextArea.getText())
                            .append("\n")
                            .append(inputField.getText());
                    charTextArea.setText(sb.toString());
                    inputField.setText("");
                    sb.setLength(0);
                } else {
                    inputField.setText("");
                    sb.setLength(0);
                    return;
                }
            }
        });

        JComboBox<String> roomsOpt = new JComboBox<>(new String[]{"Чат 1", "Чат 2", "Чат 3"});
        controlPanel.add(roomsOpt, BorderLayout.WEST);

        JButton submitButton = new JButton("Отправить");
        controlPanel.add(submitButton, BorderLayout.EAST);
        submitButton.addActionListener(new SubmitButtonListener(inputField, charTextArea));

        setVisible(true);
    }
}
