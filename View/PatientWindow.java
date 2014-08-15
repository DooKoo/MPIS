import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PatientWindow extends JFrame {
    private Patient CurrentPatient;

    private JPanel MainPanel;

    private JTextField NameField;
    private JComboBox<String> SexComboBox;
    private JTextField AgeField;
    private JButton AddButton;

    private JTable DataTable;
    private JScrollPane DataTableScrollPane;

    PatientWindow(final Patient patient){
        setTitle(patient.getName());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(100,100);
        setSize(350,450);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        CurrentPatient = patient;

        MainPanel = new JPanel(null);
        MainPanel.setBounds(0, 0, 350, 450);
        MainPanel.setBackground(Main.WHITE);
        add(MainPanel);

        NameField = new JTextField(10);
        NameField.setText(patient.getName());
        NameField.setEditable(false);

        SexComboBox = new JComboBox<String>();
        SexComboBox.insertItemAt("Чоловік",0);
        SexComboBox.insertItemAt("Жінка",1);
        SexComboBox.insertItemAt("Не визначено", 2);
        SexComboBox.setBackground(Main.WHITE);
        SexComboBox.setSelectedIndex(patient.getSex().ordinal());
        SexComboBox.setEditable(false);

        AgeField = new JTextField(10);
        AgeField.setText(patient.getYearOfBirthday().toString());
        AgeField.setEditable(false);

        JTextArea nameArea = new JTextArea("ПІБ");
        nameArea.setEditable(false);
        nameArea.setBounds(70,10,85,20);
        NameField.setBounds(0, 40, 150, 20);

        JTextArea sexArea = new JTextArea("Стать");
        sexArea.setEditable(false);
        sexArea.setBounds(160,10,60,20);
        SexComboBox.setBounds(160,40,110,20);

        JTextArea ageArea = new JTextArea("Рік народження");
        ageArea.setEditable(false);
        ageArea.setBounds(250,10,100,20);
        AgeField.setBounds(280, 40, 50, 20);

        DataTable = new JTable();
        DataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        updateTable();
        DataTableScrollPane = new JScrollPane(DataTable);
        DataTableScrollPane.setBounds(0, 70, 345, 330);

        AddButton = new JButton("Додати");
        AddButton.setBounds(245,400,100,20);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddResearchWindow(CurrentPatient);
            }
        });

        MainPanel.add(nameArea);
        MainPanel.add(sexArea);
        MainPanel.add(ageArea);
        MainPanel.add(NameField);
        MainPanel.add(AgeField);
        MainPanel.add(SexComboBox);
        MainPanel.add(DataTableScrollPane);
        MainPanel.add(AddButton);

        MainPanel.updateUI();
        DataTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id = DataTable.getSelectedRow();
                new AddResearchWindow(new TableModel((CurrentPatient.getId())).getResearch(id));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void updateTable()
    {
        DataTable.setModel(new TableModel(CurrentPatient.getId()));
        DataTable.updateUI();
        DataTable.getColumnModel().getColumn(0).setPreferredWidth(47);
        DataTable.getColumnModel().getColumn(0).setResizable(false);
        DataTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        DataTable.getColumnModel().getColumn(1).setResizable(false);
        DataTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        DataTable.getColumnModel().getColumn(2).setResizable(false);
    }
}


