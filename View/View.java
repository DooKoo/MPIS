import javax.swing.*;

public class View extends JFrame {
    private JPanel RightPanel;
    private JPanel LeftPanel;
    private JPanel ResearchsTable;
    private JPanel SearchPanel;

    private JTable DataTable;
    private JScrollPane DataTableScrollPane;

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

        // Research Button panel;
        addButtonsBar(360,800, ResearchAddButton, ResearchDeleteButton);
        addButtonsBar(904,840, PatientAddButton, PatientDeleteButton);

        SearchPanel = new JPanel(null);
        SearchPanel.setBackground(java.awt.Color.BLUE);
        SearchPanel.setBounds(500, 0, 500,100);

        LeftPanel = new JPanel(null);
        LeftPanel.setBounds(0, 0, 500, 900);

        RightPanel = new JPanel(null);
        RightPanel.setBounds(500, 100, 500, 800);

        // Researchs table;
        ResearchsTable = new JPanel(null);
        ResearchsTable.setBounds(50, 300, 400, 500);
        ResearchsTable.setBackground(java.awt.Color.DARK_GRAY);
        LeftPanel.add(ResearchsTable);

        add(LeftPanel);

        // Search element;
        add(SearchPanel);

        //DataTable;
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
        DataTableScrollPane.setBounds(0,0,495,745);
        RightPanel.add(DataTableScrollPane);

        add(RightPanel);

    }

    //360,800
    private void addButtonsBar(int x, int y, JButton addButton, JButton deleteButton ) {
        JPanel ButtonPanel = new JPanel(null);
        ButtonPanel.setBounds(x, y, 90, 30);

        addButton = new JButton("+");
        addButton.setBounds(0, 0, 45, 30);

        deleteButton = new JButton("-");
        deleteButton.setBounds(45,0,45,30);

        ButtonPanel.add(addButton);
        ButtonPanel.add(deleteButton);

        add(ButtonPanel);
    }
}
