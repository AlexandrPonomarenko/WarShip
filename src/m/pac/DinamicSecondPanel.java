package m.pac;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Alexandr on 19.06.2017.
 */
public class DinamicSecondPanel extends JPanel implements ActionListener
{
    private JButton buttonOneShip;
    private JButton buttonTwoShip;
    private JButton buttonThreeShip;
    private JButton buttonFourShip;
    private JButton buttonNew;
    private JButton buttonVerOrHor;
    private JButton go;
    private ArrayList<JButton> arrayList;
    private EventListenerList eventListenerList;
    private DinamicPanel dp;
//    private MyButton b;
//    private int widthBut = 0;
//    private boolean flag = true;


    public DinamicSecondPanel(int w, int h)
    {
        setPreferredSize(new Dimension(w,h));
        arrayList = new ArrayList<>();
        eventListenerList = new EventListenerList();
        setLayout(new GridBagLayout());
        setBackground(Color.orange);
//        dp = new DinamicPanel();
//        dp.getClassPanel();

        setButtonPanel(buttonOneShip, "OneShip", 0);
        setButtonPanel(buttonTwoShip, "TwoShip", 0);
        setButtonPanel(buttonThreeShip, "ThreeShip", 0);
        setButtonPanel(buttonFourShip, "FourShip", 0);
        setButtonPanel(buttonVerOrHor, "VerOrHor", 0);
        setButtonPanel(buttonNew, "New", 0);
        setButtonPanel(go, "GO", 1);

        setAllSizeButton();
    }

    private void setButtonPanel(JButton button, String name, int weighty)
    {
        button = new JButton(name);
        arrayList.add(button);
        add(button, new GridBagConstraints(0,GridBagConstraints.RELATIVE,1,1,0,weighty,GridBagConstraints.NORTHWEST,GridBagConstraints.HORIZONTAL,
                new Insets(0,0,0,0),0,0));
    }

    private void setAllSizeButton()
    {
            for (int i = 0; i < arrayList.size(); i++)
            {
                arrayList.get(i).addActionListener(this);
            }
        }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //textField.setText(e.getActionCommand());
        fireMyEvent(new MyEventObject(e, e.getActionCommand()));
//        dp.getNameStateButton(e.getActionCommand());
    }

    public void addMyEventListener(MyEventListener listener)
    {
        listenerList.add(MyEventListener.class, listener);
    }

    public void removeMyEventListener(MyEventListener listener)
    {
        listenerList.remove(MyEventListener.class, listener);
    }

    private void fireMyEvent(MyEventObject evt)
    {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i + 2)
        {
            if (listeners[i] == MyEventListener.class)
            {
                ((MyEventListener) listeners[i + 1]).clickButton(evt);
            }
        }
    }

}
