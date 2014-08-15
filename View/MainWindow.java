
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainWindow extends JFrame {
    private Color MainColor = Color.WHITE;

    private JPanel MainPanel;

    private JTextField NameField;
    private JComboBox<String> SexComboBox;
    private JTextField AgeField;
    private JButton AddButton;
    private JButton SearchButton;

    MainWindow() {
        setTitle("Система обліку пацієнтів");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 450);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        MainPanel = new JPanel(null);
        MainPanel.setBounds(0, 0, 350, 450);
        MainPanel.setBackground(MainColor);
        add(MainPanel);

        NameField = new JTextField(10);

        SexComboBox = new JComboBox<String>();
        SexComboBox.insertItemAt("Чоловік", 0);
        SexComboBox.insertItemAt("Жінка", 1);
        SexComboBox.insertItemAt("Не визначено", 2);
        SexComboBox.setBackground(MainColor);
        SexComboBox.setSelectedIndex(0);

        AgeField = new JTextField(10);

        JTextArea nameArea = new JTextArea("ПІБ");
        nameArea.setEditable(false);
        nameArea.setBounds(165, 50, 95, 20);
        NameField.setBounds(100, 70, 150, 20);

        JTextArea sexArea = new JTextArea("Стать");
        sexArea.setEditable(false);
        sexArea.setBounds(160, 150, 100, 20);
        SexComboBox.setBounds(120, 170, 110, 20);

        JTextArea ageArea = new JTextArea("Рік народження");
        ageArea.setEditable(false);
        ageArea.setBounds(130, 250, 100, 20);
        AgeField.setBounds(150, 270, 50, 20);
        AgeField.setText("19");
        AgeField.setCaretPosition(2);
        AddButton = new JButton("Додати");
        AddButton.setBounds(65, 325, 100, 20);

        SearchButton = new JButton("Знайти");
        SearchButton.setBounds(185, 325, 100, 20);

        MainPanel.add(nameArea);
        MainPanel.add(sexArea);
        MainPanel.add(ageArea);
        MainPanel.add(NameField);
        MainPanel.add(AgeField);
        MainPanel.add(SexComboBox);
        MainPanel.add(AddButton);
        MainPanel.add(SearchButton);

        MainPanel.updateUI();

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPatientDataCorrect()) {
                    Patient tempPatient = new Patient(Main.MBase.getPatientCount(), NameField.getText(),
                            Integer.parseInt(AgeField.getText()),
                            Patient.stringToSex(SexComboBox.getSelectedItem().toString()));

                    Main.MBase.addPatient(tempPatient);
                    NameField.setText("");
                    AgeField.setText("");
                    SexComboBox.setSelectedIndex(0);
                    Main.PWindow = new PatientWindow(tempPatient);
                } else {
                    new AlertWindow("Введіть вірні дані!");
                }
            }
        });

        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPatientDataCorrect()) {
                    Patient tempPatient = new Patient(0, NameField.getText(),
                            Integer.parseInt(AgeField.getText()),
                            Patient.stringToSex(SexComboBox.getSelectedItem().toString()));

                    tempPatient = Main.MBase.getPatient(tempPatient);
                    if (tempPatient == null) {
                        new AlertWindow("Пацієнта не знайдено!");
                    } else {
                        Main.PWindow = new PatientWindow(tempPatient);
                    }
                    NameField.setText("");
                    AgeField.setText("");
                    SexComboBox.setSelectedIndex(0);
                } else {
                    new AlertWindow("Введіть вірні дані!");
                }
            }
        });
        NameField.requestFocusInWindow();
    }

    private boolean isPatientDataCorrect(){
        Pattern rulesForAge = Pattern.compile("^19[0-9]{2}$");
        Matcher checkForAge = rulesForAge.matcher(AgeField.getText());

        Pattern rulesForName = Pattern.compile("^[А-ЯІЇ][А-ЯІЇа-яії-]{2,32}[ ][А-ЯІЇ][.][А-ЯІЇ][.]$");
        Matcher checkForName = rulesForName.matcher(NameField.getText());

        if (checkForName.matches() && (SexComboBox.getSelectedIndex()<2) && checkForAge.matches())
            return true;

            return false;
    }
}
