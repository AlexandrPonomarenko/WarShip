package m.pac;

import javax.swing.*;
import java.awt.*;

public class SecondPanel extends JPanel
{
    private int x;
    private int y;

    public SecondPanel(int w, int h)
    {
        x = getWidth();
        y = getHeight();

        System.out.println(x + " ++++++++++++++++++++++++++++++ " + y);
        setPreferredSize(new Dimension(w,h ));
        setBackground(Color.RED);
    }

    public void paint(Graphics g)
    {
        //super(g);
        g.setColor(Color.black);
        System.out.println(getHeight() + " -- " + this.getSize());
        drawFieldWar(g, 40, 20);
        System.out.println("Method Srabotal");
    }

    private void drawFieldWar(Graphics g, int wX, int hY)
    {
        int w = this.getWidth();
        int h = this.getHeight();
        int halfWidth = w / 2;
        int top = 20;
        int left = 40;
        int right = 40;
        int bottom = 20;

        System.out.println(getHeight() + " -- " + this.getSize() + "ЭТО БЛОК ГРАФИКИ!");

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
}
