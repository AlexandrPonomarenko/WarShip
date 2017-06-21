package m.pac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class DinamicPanel extends JPanel
{
    private int width = 0;
    private int height = 0;
    private int top = 40;
    private int bottom = 40;
    private int left = 50;
    private int right = 50;

    private int mouseX;
    private int mouseY;

    private int recWidth = 0;
    private int recHeight = 0;

    private int [][] arrayField;
    private boolean flag = true;

    public DinamicPanel(int w, int h)
    {
        setPreferredSize(new Dimension(w,h));
        addActionListener();
        addMouseMotion();
        arrayField = new int[10][10];
    }


    public void paint(Graphics g)
    {
        setCopPanel(getWidth(),getHeight());
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        drawSinglWeb(g, recWidth, recHeight, top, left);
        g.setColor(Color.BLUE);
        drawCellClick(g);
        drawCell(g);
    }


    private void drawSinglWeb(Graphics g, int stepX, int stepY, int top, int left)
    {
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

    private void setCopPanel(int w, int h)
    {
        width = w;
        height = h;

        recWidth = ((width) - left - right) / 10;
        recHeight = (height - top - bottom) / 10;
    }

    private void drawCellClick(Graphics g)
    {
        g.fillRect(mouseX - (recWidth / 2), mouseY - (recHeight / 2), recWidth, recHeight);
    }

    private void setCor(int startPoz, int border, int length, int corX, int corY)
    {
        int x = corX;
        int y = corY;
        int indexX = 0, indexY = 0;

        boolean flagX = false;
        boolean flagY = false;

        if((x >= startPoz && x <= border)  && (y >= top && y <= height - bottom))
        {
            for (int i = startPoz, i2 = 0; i < length; i += recWidth, i2++)
            {
                if (i + recWidth > x)
                {
                    indexX = i2;
                    flagX = true;
                    break;
                }
            }

            for (int i = top, i2 = 0; i < height - bottom; i += recHeight, i2++)
            {
                if (i + recHeight > y)
                {
                    indexY = i2;
                    flagY = true;
                    break;
                }
            }
            System.out.println(indexX + " " + indexY);
            if (flagX && flagY)
            {
                arrayField[indexX][indexY] = 1;
            }
        }
    }

    private void drawCell(Graphics g)
    {
        for (int i = 0; i < arrayField.length; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                if (arrayField[i][j] == 1) {
                    g.fillRect(i * recWidth + right, j * recHeight + top, recWidth, recHeight);
                }
            }
        }
    }

    private void addActionListener()
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //flag = false;
                //super.mouseClicked(e);
                System.out.println("CLICK");
                setCor(left, width / 2 - right, (width / 2) - left - right, e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                //flag = true;

            }
        });
    }

    private void addMouseMotion()
    {
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e)
            {

            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                //super.mouseMoved(e);

                    mouseX = e.getX();
                    mouseY = e.getY();
                    System.out.println(mouseX + " ======= " + mouseY);
                    repaint();

            }
        });
    }


}
