import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class View extends JFrame {
    private DataBaseCore MainBase;
    private JPanel BottomRightPanel;
    private JPanel BottomLeftPanel;
    private JPanel ResearchsPanel;
    private JPanel TopRightPanel;
    private JPanel TopLeftPanel;

    private JTable DataTable;
    private JScrollPane DataTableScrollPane;

    private JTextField NameField;
    private JComboBox<String> SexComboBox;
    private JTextField AgeField;
    private JButton ConfirmButton;

    private JTextField SearchNameField;
    private JComboBox<String> SearchSexComboBox;
    private JTextField SearchAgeField;
    private JButton SearchButton;

    private JButton ResearchAddButton;
    private JButton ResearchDeleteButton;

    private JButton PatientAddButton;
    private JButton PatientDeleteButton;

    private Color MainColor = Color.WHITE;

    View(){
        MainBase= new DataBaseCore("B:\\Maindb.mdb");
        Init();
    }

    private void Init()
    {
        setTitle("Система обліку пацієнтів");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,900);
        setResizable(false);
        setVisible(true);
        setBackground(MainColor);
        setLayout(null);

        // PANELS;
        BottomLeftPanel = new JPanel(null);
        BottomLeftPanel.setBounds(0, 320, 500, 523);
        BottomLeftPanel.setBackground(MainColor);
        add(BottomLeftPanel);

        ResearchsPanel = new JPanel(null);
        ResearchsPanel.setBounds(50, 23, 400, 500);
        ResearchsPanel.setBackground(Color.LIGHT_GRAY);
        BottomLeftPanel.add(ResearchsPanel);

        TopLeftPanel = new JPanel(null);
        TopLeftPanel.setBounds(0, 0, 500, 320);
        TopLeftPanel.setBackground(MainColor);
        add(TopLeftPanel);

        TopRightPanel = new JPanel(null);
        TopRightPanel.setBounds(500, 0, 500, 100);
        TopRightPanel.setBackground(MainColor);
        add(TopRightPanel);

        BottomRightPanel = new JPanel(null);
        BottomRightPanel.setBounds(500, 100, 500, 743);
        BottomRightPanel.setBackground(MainColor);
        add(BottomRightPanel);

        // Patient View;
        ConfirmButton = new JButton("Прийняти");
        ConfirmButton.setBounds(210, 290, 100, 20);

        NameField = new JTextField(10);
        AgeField = new JTextField(4);
        SexComboBox = new JComboBox<String>();

        TopLeftPanel.add(addInputOfPatient(0,200,NameField, AgeField, SexComboBox));
        TopLeftPanel.add(ConfirmButton);
        TopLeftPanel.updateUI();

        // Search View;
        SearchButton = new JButton("Пошук");
        SearchButton.setBounds(210, 60, 100, 20);

        SearchNameField = new JTextField(10);
        SearchAgeField = new JTextField(4);
        SearchSexComboBox = new JComboBox<String>();

        TopRightPanel.add(addInputOfPatient(0,10,SearchNameField, SearchAgeField, SearchSexComboBox));
        TopRightPanel.add(SearchButton);
        TopRightPanel.updateUI();

        // Patient table;
        final TableModel MainModel = new TableModel(MainBase.getPatients());
        DataTable = new JTable(MainModel);
        DataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DataTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        DataTable.getColumnModel().getColumn(0).setResizable(false);
        DataTable.getColumnModel().getColumn(1).setPreferredWidth(235);
        DataTable.getColumnModel().getColumn(1).setResizable(false);
        DataTable.getColumnModel().getColumn(2).setPreferredWidth(106);
        DataTable.getColumnModel().getColumn(2).setResizable(false);
        DataTable.getColumnModel().getColumn(3).setPreferredWidth(86);
        DataTable.getColumnModel().getColumn(3).setResizable(false);
        DataTableScrollPane = new JScrollPane(DataTable);
        DataTableScrollPane.setBounds(0, 0, 495, 743);
        BottomRightPanel.add(DataTableScrollPane);

        BottomRightPanel.updateUI();
        BottomLeftPanel.updateUI();

        // Add/Delete buttons;
        PatientAddButton = new JButton();
        PatientDeleteButton = new JButton();
        ResearchAddButton = new JButton();
        ResearchDeleteButton = new JButton();
        addButtonsBar(888,843, PatientAddButton, PatientDeleteButton);
        addButtonsBar(360, 843, ResearchAddButton, ResearchDeleteButton);

        // BUTTONS ACTIONS;
        PatientAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainBase.add(new Patient(0,"",1920, Patient.Sex.None));
                MainModel.setModel(MainBase.getPatients());
                DataTable.updateUI();
                int row = MainBase.getCount()-1;
                DataTable.setRowSelectionInterval(row, row);
                setInputOfPatient(new Patient(row, DataTable.getValueAt(row,1).toString(),
                                                   (Integer)DataTable.getValueAt(row,2),
                                                    Patient.stringToSex(DataTable.getValueAt(row,3).toString())));
            }
        });

        ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int Patientid = DataTable.getSelectedRow();
                MainBase.getPatients().set(Patientid, new Patient(Patientid,NameField.getText(),
                                                          Integer.parseInt(AgeField.getText()),
                                                          Patient.stringToSex(SexComboBox.getSelectedItem().toString())));
                MainModel.setModel(MainBase.getPatients());
                DataTable.updateUI();
            }
        });

        DataTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = DataTable.getSelectedRow();
                setInputOfPatient(new Patient(row, DataTable.getValueAt(row,1).toString(),
                                                   (Integer)DataTable.getValueAt(row,2),
                                                   Patient.stringToSex(DataTable.getValueAt(row,3).toString())));
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

    private void addButtonsBar(int x, int y, JButton addButton, JButton deleteButton ) {
        JPanel ButtonPanel = new JPanel(null);
        ButtonPanel.setBounds(x, y, 90, 30);
        add(ButtonPanel);

        addButton.setText("+");
        addButton.setBounds(0, 0, 45, 30);

        deleteButton.setText("-");
        deleteButton.setBounds(45,0,45,30);

        ButtonPanel.add(addButton);
        ButtonPanel.add(deleteButton);

        ButtonPanel.updateUI();
    }

    private JPanel addInputOfPatient(int x, int y, JTextField nameField, JTextField ageField, JComboBox<String> sexComboBox) {
        JPanel patientPanel = new JPanel(null);
        patientPanel.setBackground(MainColor);
        patientPanel.setBounds(x,y,500,40);

        JTextArea nameArea = new JTextArea("ПІБ");
        nameArea.setEditable(false);
        nameArea.setBounds(65,0,95,20);

        JTextArea sexArea = new JTextArea("Стать");
        sexArea.setEditable(false);
        sexArea.setBounds(210,0,100,20);

        JTextArea ageArea = new JTextArea("Рік народження");
        ageArea.setEditable(false);
        ageArea.setBounds(375,0,100,20);

        nameField.setBounds(0,20,150,20);

        sexComboBox.insertItemAt("Чоловік",0);
        sexComboBox.insertItemAt("Жінка",1);
        sexComboBox.insertItemAt("Не визначено",2);
        sexComboBox.setBackground(MainColor);
        sexComboBox.setBounds(210,20,110,20);

        ageField.setBounds(400,20,50,20);

        patientPanel.add(nameArea);
        patientPanel.add(sexArea);
        patientPanel.add(ageArea);
        patientPanel.add(nameField);
        patientPanel.add(ageField);
        patientPanel.add(sexComboBox);

        return patientPanel;
    }

    private void setInputOfPatient(Patient _inp)
    {
        NameField.setText(_inp.getName());
        AgeField.setText(_inp.getYearOfBirthday().toString());
        if (_inp.sexToString().equals("Чоловік"))
            SexComboBox.setSelectedIndex(0);
        else if (_inp.sexToString().equals("Жінка"))
            SexComboBox.setSelectedIndex(1);
        else
            SexComboBox.setSelectedIndex(2);
    }
}
