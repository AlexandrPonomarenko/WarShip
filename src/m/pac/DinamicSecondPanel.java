package m.pac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Alexandr on 19.06.2017.
 */
public class DinamicSecondPanel extends JPanel
{
//    private JButton buttonOneShip;
//    private JButton buttonTwoShip;
//    private JButton buttonThreeShip;
//    private JButton buttonFourShip;
//    private JButton buttonNew;
//    private JButton buttonVerOrHor;
//    private JButton go;
    private ArrayList<MyButton> arrayList;
    private MyButton b;
    private int widthBut = 0;
    private boolean flag = true;


    public DinamicSecondPanel(int w, int h)
    {
        setPreferredSize(new Dimension(w,h));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        arrayList = new ArrayList<>();
//        b.setSizeButton(100,30);
//        b.setColorButton(22,33,44);
//        buttonOneShip = new JButton("dratuti");
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                b.setSizeButton(50,30);
//                buttonOneShip.setPreferredSize(new Dimension(50, 20));
//            }
//        });



         setButtonPanel(b , "One");
         setButtonPanel(b , "Two");
         setButtonPanel(b , "Three");
         setButtonPanel(b , "Four");
         setButtonPanel(b , "VerOrHor");
         setButtonPanel(b , "New");
         setButtonPanel(b , "GO");
         setAllSizeButton();
    }

    private void setButtonPanel(MyButton but, String name)
    {
        but = new MyButton(name);
        setWidthBut(but.getSizeButtonHeight());
        arrayList.add(but);
        add(but);
    }

    private void setAllSizeButton()
    {
        if(flag) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).setSizeButton(widthBut);
                System.out.println(" +++++++++++++++++ " + arrayList.get(i).getSizeButtonWidth());
            }
        }

        repaint();
    }
    private void setWidthBut(int w)
    {
        if(w >= widthBut)
        {
            widthBut = w;
        }
    }

    public void setFlag(boolean fl){flag = fl;}


    private class MyButton extends JButton
    {

        public MyButton()
        {

        }
        public MyButton(String name)
        {
            this.setText(name);
        }

        public void setSizeButton(int w)
        {
            //this.setPreferredSize(new Dimension(getWidth() * 2,getHeight() + 5));
            setSize(getWidth() * 2, getHeight());
        }
        public void setColorButton(int r, int g, int b)
        {
            setBackground(new Color(r,g,b));
        }
        public int getSizeButtonWidth()
        {
            return getWidth();
        }

        public int getSizeButtonHeight()
        {
            return getHeight();
        }
        public void setNameButton(String name)
        {
            setText(name);
        }

    }

}
