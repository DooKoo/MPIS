import java.awt.*;

public class Main {
    public static DataBaseCore MBase = new DataBaseCore("E:/CodingForSoul/Git/MPIS/db/devdb.mdb");
    public static PatientWindow PWindow;
    final public static Color WHITE = Color.WHITE;
    public static void main(String args[])
    {
       new MainWindow();
    }
}
