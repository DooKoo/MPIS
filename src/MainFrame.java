import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Illya on 06.07.2014.
 */
public class MainFrame extends JFrame {
    private JPanel ButtonsPanel;
    private JPanel TablePanel;
    private JTable DataTable;
    private JScrollPane DataTableScrollPane;


    private JButton AddButton;
    private JButton DeleteButton;

    public void Init()
    {
        setTitle("Система обліку пацієнтів");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        //Initialization of panels;
        ButtonsPanel = new JPanel(null);
        ButtonsPanel.setBounds(0,0,120,700);

        TablePanel = new JPanel(null);
        TablePanel.setBounds(120,0,650,700);


        //Buttons;
        AddButton = new JButton("Додати");
        AddButton.setBounds(0, 0, 120, 40);
        ButtonsPanel.add(AddButton);

        DeleteButton = new JButton("Видалити");
        DeleteButton.setBounds(0, 40, 120, 40);
        ButtonsPanel.add(DeleteButton);

        add(ButtonsPanel);

        //DataTable;
        TableModel MainModel = new TableModel();
        MainModel.testInit();
        DataTable = new JTable(MainModel);
        DataTableScrollPane = new JScrollPane(DataTable);
        DataTableScrollPane.setBounds(0,0,580,700);
        TablePanel.add(DataTableScrollPane);

        add(TablePanel);

    }
}
