package m.pac;

import javax.swing.*;
import java.awt.*;

public class SecondPanel extends JPanel
{

    public SecondPanel(int w, int h)
    {
        setPreferredSize(new Dimension(w,h ));
        setBackground(Color.RED);
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(29,172,214));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        drawFieldWar(g);
        drawFieldWarTwo(g);
        g.setColor(Color.red);
        g.fillRect(getWidth() / 2 - 20, 0,40, getHeight());
    }

    private void drawFieldWar(Graphics g)
    {
        int w = this.getWidth();
        int h = this.getHeight();
        int halfWidth = w / 2;
        int top = 20;
        int left = 40;
        int right = 40;
        int bottom = 20;


        int stepX = (halfWidth - right - left) / 11;
        int stepY = (h - top - bottom) / 11;

        for (int i = 0; i < 11; i++ )
        {
            int point = (i * stepX) + left;
            g.drawLine(point, top, point,stepY * 10 + top);
        }

        for (int i = 0; i < 11; i++ )
        {
            int point = (i * stepY) + top;
            g.drawLine(left, point, stepX * 10 + left, point);
        }
    }

    private void drawFieldWarTwo(Graphics g)
    {
        int w = this.getWidth();
        int h = this.getHeight();
        int top = 20;
        int left = 572;
        int right = 40;
        int bottom = 20;

        int stepX = (w  - left) / 11;
        int stepY = (h - top - bottom) / 11;

        for (int i = 0; i < 11; i++ )
        {
            int point = (i * stepX) + left;
            g.drawLine(point, top, point,stepY * 10 + top);
        }

        for (int i = 0; i < 11; i++ )
        {
            int point = (i * stepY) + top;
            g.drawLine(left, point, stepX * 10 + left, point);
        }
    }

}
