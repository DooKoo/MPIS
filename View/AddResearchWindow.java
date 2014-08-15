import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddResearchWindow extends JFrame {
    private JPanel MainPanel;

    private JComboBox<String> TypeComboBox;
    private JTextField DateField;
    private JButton AcceptButton;
    private JTextField FromWhoField;
    private JTextField FirstDiagnosField;
    private JComboBox<String> DoctorComboBox;
    private JComboBox<String> StacionarComboBox;
    private JTextField NextResearchField;
    private JTextField CategoryField;
    private JTextField BiophysiaField;
    private JTextField ManipulationField;
    private JTextField OperationsField;
    private JTextField CitoField;
    private JComboBox<Integer> FirstComboBox;
    private JComboBox<Integer> First2ComboBox;
    private JComboBox<String> ColonoscopyComboBox;
    private JTextField NotesField;
    private JTextArea ResultArea;
    private JTextArea LocalChangesArea;


    AddResearchWindow(final Patient patient) {
        setTitle("Нове дослідження");
        init();

        AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Research tmp = new Research();
                tmp.setBiopsiya(BiophysiaField.getText());
                tmp.setCategory(CategoryField.getText());
                tmp.setCito(CitoField.getText());
                if (ColonoscopyComboBox.getSelectedItem()=="Так"){
                    tmp.setColonoscopy(true);
                }
                else {
                    tmp.setColonoscopy(false);
                }
                tmp.setDateOfResearch(DateField.getText());
                tmp.setDoctor(DoctorComboBox.getSelectedItem().toString());
                tmp.setFirst(Integer.parseInt(FirstComboBox.getSelectedItem().toString()));
                tmp.setFirst2(Integer.parseInt(First2ComboBox.getSelectedItem().toString()));
                tmp.setFirstDiagnos(FirstDiagnosField.getText());
                tmp.setFromWho(FromWhoField.getText());
                tmp.setId(Main.MBase.getResearchCount());
                tmp.setIdOfPatient(patient.getId());
                tmp.setLocalChanges(LocalChangesArea.getText());
                tmp.setManipulations(ManipulationField.getText());
                tmp.setNextResearch(NextResearchField.getText());
                tmp.setNotes(NotesField.getText());
                tmp.setOpeartions(OperationsField.getText());
                tmp.setResult(ResultArea.getText());
                if(StacionarComboBox.getSelectedItem()=="Стаціонар") {
                    tmp.setStacionar(true);
                }
                else {
                    tmp.setStacionar(false);
                }
                tmp.setTypeOfResearch(TypeComboBox.getSelectedItem().toString());
                Main.MBase.addResearch(tmp);
                Main.PWindow.updateTable();
                dispose();
            }
        });

        MainPanel.updateUI();

    }

    AddResearchWindow(final Research research) {
        setTitle(research.getTypeOfResearch() + ":" + research.getId());
        init();

        TypeComboBox.setEditable(false);
        DateField.setEditable(false);


        TypeComboBox.setSelectedItem(research.getTypeOfResearch());
        DateField.setText(research.getDateOfResearch());
        FromWhoField.setText(research.getFromWho());
        FirstDiagnosField.setText(research.getFirstDiagnos());
        DoctorComboBox.setSelectedItem(research.getDoctor());
        if (research.isStacionar()) {
            StacionarComboBox.setSelectedItem("Стаціонар");
        }
        else {
            StacionarComboBox.setSelectedItem("Амбулаторний");
        }
        NextResearchField.setText(research.getNextResearch());
        CategoryField.setText(research.getCategory());
        BiophysiaField.setText(research.getBiopsiya());
        ManipulationField.setText(research.getManipulations());
        OperationsField.setText(research.getOpeartions());
        CitoField.setText(research.getCito());
        FirstComboBox.setSelectedItem(research.getFirst());
        First2ComboBox.setSelectedItem(research.getFirst2());
        if (research.isColonoscopy()) {
            ColonoscopyComboBox.setSelectedItem("Так");
        }
        else {
            ColonoscopyComboBox.setSelectedItem("Ні");
        }
        NotesField.setText(research.getNotes());
        ResultArea.setText(research.getResult());
        LocalChangesArea.setText(research.getLocalChanges());

        AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(550, 550);
        setResizable(false);
        setLocation(450, 50);
        setVisible(true);
        setLayout(null);

        MainPanel = new JPanel(null);
        MainPanel.setBackground(Main.WHITE);
        MainPanel.setBounds(0, 0, 550, 550);
        add(MainPanel);

        // Change the Type;
        TypeComboBox = new JComboBox<String>(new String[]{"ректероманоскопія", "гастроскопія"});
        TypeComboBox.setBackground(Main.WHITE);
        MComponent Type = new MComponent(5,35, 150, 40,TypeComboBox,"Дослідження:");

        // Date of research;
        DateField = new JTextField();
        DateField.setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
        DateField.setBackground(Main.WHITE);
        DateField.setEditable(false);
        MComponent MDate = new MComponent(200, 30, 100, 40, DateField, "Дата:");

        // Field for first diagnos;
        FirstDiagnosField = new JTextField();
        MComponent MFirstDiagnos = new MComponent(380,30,150,40, FirstDiagnosField,"Діагноз при скеруванні:");

        // Who is direct the patient;
        FromWhoField = new JTextField(10);
        MComponent FromWho = new MComponent(5, 80, 100, 40, FromWhoField, "Від кого:");

        // Who make the research;
        DoctorComboBox = new JComboBox<String>(new String[]{"Шевчук", "Погорецький"});
        DoctorComboBox.setBackground(Main.WHITE);
        MComponent Doctor = new MComponent(200,80,150,40,DoctorComboBox, "Лікар:");

        // Patient from stacionar of ambulator;
        StacionarComboBox = new JComboBox<String>(new String[]{"Амбулаторний","Стаціонар"});
        StacionarComboBox.setBackground(Main.WHITE);
        MComponent Stacionar = new MComponent(380,80,150,40, StacionarComboBox, "Амб.\\ст:");

        // When next research;
        NextResearchField = new JTextField("Ні");
        MComponent newxtResearch = new MComponent(5,130,150,40, NextResearchField,"Наступне обстеження:");

        // Which category;
        CategoryField = new JTextField("Ні");
        MComponent category = new MComponent(200,130,100,40,CategoryField, "Категорія:");

        // Is biophysia made;
        BiophysiaField = new JTextField("Ні");
        MComponent biophysia = new MComponent(380,130,100,40, BiophysiaField, "Біопсія:");

        // Is manipulations made;
        ManipulationField = new JTextField("Ні");
        MComponent manipulations = new MComponent(5,180,100,40,ManipulationField, "Маніпуляції:");

        // Is operation made;
        OperationsField = new JTextField("Ні");
        MComponent operations = new MComponent(200,180,100,40,OperationsField, "Операції:");

        // Time o research;
        CitoField = new JTextField("00:00");
        MComponent cito = new MComponent(380,180,100,40,CitoField, "Час:");

        // How much of research was;
        FirstComboBox = new JComboBox<Integer>(new Integer[]{1,2});
        FirstComboBox.setBackground(Main.WHITE);
        MComponent firstrs = new MComponent(80,230,170,40,FirstComboBox,"Вперше "+TypeComboBox.getSelectedItem().toString()+":");

        // Special notes;
        NotesField = new JTextField();
        MComponent notes = new MComponent(300,230,170,40,NotesField,"Особливі відмітки:");

        // Result of research;
        ResultArea = new JTextArea(4,10);
        ResultArea.setLineWrap(true);
        ResultArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        MComponent result = new MComponent(70,280,200,150,ResultArea,"Висновок:");

        // Local changes of the patient;
        LocalChangesArea = new JTextArea(4,10);
        LocalChangesArea.setLineWrap(true);
        LocalChangesArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        MComponent localChanges = new MComponent(280,280,200,150, LocalChangesArea,"Локальні зміни:");

        // Is colonoscopy do?
        ColonoscopyComboBox = new JComboBox<String>(new String[]{"Так", "Ні"});
        ColonoscopyComboBox.setBackground(Main.WHITE);
        MComponent colonoscopy = new MComponent(70,440,150,40,ColonoscopyComboBox,"Колоноскопія:");

        // How much colonoscopy was;
        First2ComboBox = new JComboBox<Integer>(new Integer[]{1,2});
        First2ComboBox.setBackground(Main.WHITE);
        MComponent firstks = new MComponent(280,440,150,40,First2ComboBox,"Вперше колоноскопія:");

        // Accept Button;
        AcceptButton = new JButton("Прийняти");
        AcceptButton.setBounds(200, 490, 100, 20);

        MainPanel.add(FromWho.getPanel());
        MainPanel.add(MDate.getPanel());
        MainPanel.add(MFirstDiagnos.getPanel());
        MainPanel.add(Doctor.getPanel());
        MainPanel.add(Stacionar.getPanel());
        MainPanel.add(newxtResearch.getPanel());
        MainPanel.add(category.getPanel());
        MainPanel.add(biophysia.getPanel());
        MainPanel.add(manipulations.getPanel());
        MainPanel.add(operations.getPanel());
        MainPanel.add(cito.getPanel());
        MainPanel.add(firstrs.getPanel());
        MainPanel.add(notes.getPanel());
        MainPanel.add(result.getPanel());
        MainPanel.add(localChanges.getPanel());
        MainPanel.add(colonoscopy.getPanel());
        MainPanel.add(firstks.getPanel());
        MainPanel.add(Type.getPanel());
        MainPanel.add(AcceptButton);
    }
}
