package m.pac;


import javax.swing.*;
import java.awt.*;

public class MainWindow
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new Main_Window();
                frame.setTitle("WarShip");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
