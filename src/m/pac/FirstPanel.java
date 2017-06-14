package m.pac;


import javax.swing.*;
import java.awt.*;

public class FirstPanel extends JPanel
{
    private JLabel time;
    private JLabel yourField;
    private JLabel myField;
    private JLabel status;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;

    public FirstPanel(int w, int h)
    {
        setPreferredSize(new Dimension(w,h));

        System.out.println(this.getSize() + "PERvaz panell");
        time = new JLabel("Time");
        yourField = new JLabel("YourField");
        myField = new JLabel("MyField");
        status = new JLabel("Status: ");
        add(time, BorderLayout.NORTH);
        add(status, BorderLayout.WEST);

//        gbl = new GridBagLayout();
//        setLayout(gbl);
//        gbc = new GridBagConstraints();

        setBackground(Color.ORANGE);
//        setComponetStatus(status);
//        setComponetTime(time);
//        setComponetNull(new JLabel("Hello "));
    }

//    private void setComponetStatus(Component componets)
//    {
//        add(componets, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
//                new Insets(0, 0 ,0,0 ), 0,0));
//    }
//
//    private void setComponetTime(Component componets)
//    {
////        add(componets, new GridBagConstraints(0, 1, 1, 0, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE,
////                new Insets(0, 0 ,0,0 ), 0,0));
//
//        add(componets, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
//                new Insets(0, 0 ,0,0 ), 0,0));
//    }
//
//    private void setComponetNull(Component componets)
//    {
//        add(componets, new GridBagConstraints(2, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
//                new Insets(0, 0 ,0,0 ), 0,0));
//    }
}
