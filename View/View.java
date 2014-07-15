import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
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

    View(){
        Init();
    }

    private void Init()
    {
        setTitle("Система обліку пацієнтів");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,900);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        // PANELS;
        BottomLeftPanel = new JPanel(null);
        BottomLeftPanel.setBounds(0, 320, 500, 523);
        BottomLeftPanel.setBackground(Color.WHITE);
        add(BottomLeftPanel);

        ResearchsPanel = new JPanel(null);
        ResearchsPanel.setBounds(50, 23, 400, 500);
        ResearchsPanel.setBackground(Color.DARK_GRAY);
        BottomLeftPanel.add(ResearchsPanel);

        TopLeftPanel = new JPanel(null);
        TopLeftPanel.setBounds(0, 0, 500, 320);
        TopLeftPanel.setBackground(Color.WHITE);
        add(TopLeftPanel);

        TopRightPanel = new JPanel(null);
        TopRightPanel.setBounds(500, 0, 500, 100);
        TopRightPanel.setBackground(Color.WHITE);
        add(TopRightPanel);

        BottomRightPanel = new JPanel(null);
        BottomRightPanel.setBounds(500, 100, 500, 743);
        BottomRightPanel.setBackground(Color.WHITE);
        add(BottomRightPanel);

        // Patient View;
        ConfirmButton = new JButton("Прийняти");
        ConfirmButton.setBounds(210, 290, 100, 20);

        TopLeftPanel.add(addInputOfPatient(0,200,NameField, AgeField, SexComboBox));
        TopLeftPanel.add(ConfirmButton);
        TopLeftPanel.updateUI();

        // Search View;
        SearchButton = new JButton("Пошук");
        SearchButton.setBounds(210, 60, 100, 20);

        TopRightPanel.add(addInputOfPatient(0,10,SearchNameField, SearchAgeField, SearchSexComboBox));
        TopRightPanel.add(SearchButton);
        TopRightPanel.updateUI();

        // Patient table;
        TableModel MainModel = new TableModel();
        MainModel.testInit();
        DataTable = new JTable(MainModel);
        DataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DataTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        DataTable.getColumnModel().getColumn(0).setResizable(false);
        DataTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        DataTable.getColumnModel().getColumn(1).setResizable(false);
        DataTable.getColumnModel().getColumn(2).setPreferredWidth(106);
        DataTable.getColumnModel().getColumn(2).setResizable(false);
        DataTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        DataTable.getColumnModel().getColumn(3).setResizable(false);
        DataTableScrollPane = new JScrollPane(DataTable);
        DataTableScrollPane.setBounds(0, 0, 495, 743);
        BottomRightPanel.add(DataTableScrollPane);

        BottomRightPanel.updateUI();
        BottomLeftPanel.updateUI();

        // Add/Delete buttons;
        addButtonsBar(888,843, PatientAddButton, PatientDeleteButton);
        addButtonsBar(360, 843, ResearchAddButton, ResearchDeleteButton);
    }

    private void addButtonsBar(int x, int y, JButton addButton, JButton deleteButton ) {
        JPanel ButtonPanel = new JPanel(null);
        ButtonPanel.setBounds(x, y, 90, 30);
        add(ButtonPanel);

        addButton = new JButton("+");
        addButton.setBounds(0, 0, 45, 30);

        deleteButton = new JButton("-");
        deleteButton.setBounds(45,0,45,30);

        ButtonPanel.add(addButton);
        ButtonPanel.add(deleteButton);

        ButtonPanel.updateUI();
    }

    private JPanel addInputOfPatient(int x, int y, JTextField nameField, JTextField ageField, JComboBox<String> sexComboBox) {
        JPanel patientPanel = new JPanel(null);
        patientPanel.setBackground(Color.WHITE);
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

        nameField = new JTextField(10);
        nameField.setBounds(0,20,150,20);

        sexComboBox = new JComboBox<String>( new String[]{"Чоловіча", "Жіноча"});
        sexComboBox.setBackground(Color.WHITE);
        sexComboBox.setBounds(210,20,100,20);

        ageField = new JTextField(4);
        ageField.setBounds(400,20,50,20);

        patientPanel.add(nameArea);
        patientPanel.add(sexArea);
        patientPanel.add(ageArea);
        patientPanel.add(nameField);
        patientPanel.add(ageField);
        patientPanel.add(sexComboBox);

        return patientPanel;
    }
}
