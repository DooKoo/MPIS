import javax.swing.*;

public class MComponent {
    private JComponent Component;
    private JTextArea Labe;
    private JPanel Panel;

    MComponent(){
        Panel = new JPanel(null);
        Labe = new JTextArea();
        Labe.setLocation(0,0);
        Labe.setEditable(false);
        Panel.add(Labe);
    }
    MComponent(int x, int y, int width, int height, JComponent component, String text)
    {
        this();
        Labe.setText(text);
        Labe.setSize(width, 20);
        Component = component;
        Component.setBounds(0,21,width,height-21);
        Panel.add(Component);
        Panel.setBounds(x,y,width,height);
        Panel.updateUI();
    }
    public JPanel getPanel(){
        return Panel;
    }
    void setText(String text){
        Labe.setText(text);
        Panel.updateUI();
    }
}
