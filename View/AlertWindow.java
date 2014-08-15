import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertWindow extends JFrame {
    private Color MainColor = Color.LIGHT_GRAY;
    AlertWindow(String message) {
        setTitle("Увага!");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocation(100,100);
        setVisible(true);
        setLayout(null);

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBounds(0,40,300,40);
        panel.setBackground(MainColor);
        add(panel);

        JPanel panelForColor = new JPanel(null);
        panelForColor.setBounds(0,0,300,40);
        panelForColor.setBackground(MainColor);
        add(panelForColor);

        JPanel ButtonPanel = new JPanel(new FlowLayout());
        ButtonPanel.setBounds(0,80,300,102);
        ButtonPanel.setBackground(MainColor);
        add(ButtonPanel);

        JButton OkButton = new JButton("Oк");
        ButtonPanel.add(OkButton);

        JTextArea mainMessage = new JTextArea(message);
        mainMessage.setEditable(false);
        mainMessage.setForeground(Color.RED);
        mainMessage.setBackground(MainColor);
        panel.add(mainMessage);
        panel.updateUI();

        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
