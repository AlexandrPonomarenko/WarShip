package m.pac;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics.*;

public class Drawing extends JPanel
{
    JPanel p;
    private int x;
    private int y;
    Graphics g;
    public Drawing( )
    {
        //x = w;
        //y = h;
        //g = panel.getGraphics();
        //paint(g);
        //add(panel);
        //p = panel;
    }


    //@Override
    public void paint(Graphics g)
    {
        //super(g);
        g.setColor(Color.black);
        drawFildWar(g, x / 2 - 25, y * 24 / 100);
        System.out.println("Method Srabotal");
    }

    private void drawFildWar(Graphics g, int startPositionX, int startPositionY)
    {
        for(int i = startPositionX; i <= x / 2 - 25; i += (x / 2 - 25) / 10 )
        {
            g.drawLine(startPositionX,y * 24 / 100, startPositionX, y * 96 / 100);
        }

        for(int i = startPositionY; i <= y - 20; i += (y - 20) / 10 )
        {
            g.drawLine(25,startPositionY, x / 2 - 25 , startPositionY);
        }
    }

}
