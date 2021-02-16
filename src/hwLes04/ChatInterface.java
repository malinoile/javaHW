package hwLes04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ChatInterface extends JFrame {

    //Пока отправленные сообщения хранятся здесь
    private ArrayList<String> messages;

    public ChatInterface() {
        this.messages = new ArrayList<>();
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chat");
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel blockMessages = new JPanel();
        blockMessages.setLayout(new FlowLayout(FlowLayout.CENTER));
        blockMessages.setBorder(BorderFactory.createTitledBorder("Chat messages"));
        blockMessages.setPreferredSize(new Dimension(this.getWidth() - 40, 450));

        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(520, 420));
        blockMessages.add(scrollPane);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        userPanel.setPreferredSize(new Dimension(this.getWidth() - 40, 100));

        JTextField userMessage = new JTextField();
        userMessage.setPreferredSize(new Dimension(this.getWidth() - 40, 30));
        userMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.add("Вы: " + userMessage.getText());
                userMessage.setText("");
                messageArea.setText(messages.stream().collect(Collectors.joining("\n")));
            }
        });

        JButton button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.add("Вы: " + userMessage.getText());
                userMessage.setText("");
                messageArea.setText(messages.stream().collect(Collectors.joining("\n")));
            }
        });

        userPanel.add(new JLabel("Введите ваше сообщение"));
        userPanel.add(userMessage);
        userPanel.add(button);

        add(blockMessages);
        add(userPanel);

        userPanel.setVisible(true);
        blockMessages.setVisible(true);
        setVisible(true);
    }

}
