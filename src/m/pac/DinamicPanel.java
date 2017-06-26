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
    private String buttonState;
    private int stateShip = 1;
    private int stateShipVerOrHor = 1;

    public DinamicPanel(int w, int h)
    {
        setPreferredSize(new Dimension(w,h));
        addActionListener();
        addMouseMotion();
        arrayField = new int[10][10];
    }

    public DinamicPanel(){}

    public void paint(Graphics g)
    {
        setCopPanel(getWidth(),getHeight());
        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());
//        g.setColor(Color.black);
//        drawSinglWeb(g, recWidth, recHeight, top, left);
        g.setColor(Color.BLUE);

        drawCell(g);

        g.setColor(Color.black);
        drawSinglWeb(g, recWidth, recHeight, top, left);
        drawMouseCell(g);
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
        recWidth = (width - left - right) / 10;
//        recWidth = ((width / 2) - left - right) / 10;
        recHeight = (height - top - bottom) / 10;
    }

    private void drawMouseCell(Graphics g)
    {
//        Graphics2D graphics2D = (Graphics2D) g;
//        graphics2D.setStroke(new BasicStroke(5.00f));
//        graphics2D.setColor(Color.red);
        if(flag)
        {
            if(stateShipVerOrHor == 1)
            {
                g.fillRect(mouseX - (recWidth / 2), mouseY - (recHeight / 2), recWidth * stateShip, recHeight);
//                graphics2D.drawRect(mouseX - (recWidth / 2), mouseY - (recHeight / 2), recWidth * stateShip, recHeight);
            }else
                {
                    g.fillRect(mouseX - (recWidth / 2), mouseY - (recHeight / 2), recWidth, recHeight * stateShip);
//                    graphics2D.drawRect(mouseX - (recWidth / 2), mouseY - (recHeight / 2), recWidth, recHeight * stateShip);
                }
        }
    }

    private void setCor(int startPoz, int border, int length, int corX, int corY)
    {
        int x = corX;
        int y = corY;
        int indexX = 0, indexY = 0;

        boolean flagX = false;
        boolean flagY = false;
//        setCor(left, (width / 2) - right, (width / 2) - left - right, e.getX(),e.getY());
        System.out.println("x " + x + " " + startPoz + " " + length);
        if((x >= startPoz && x <= border)  && (y >= top && y <= height - bottom))
        {

            for (int i = startPoz, i2 = 0; i <= length + startPoz; i += recWidth, i2++)
            {
                System.out.println("i " + i + " " + x);
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
            System.out.println(x + " X ---- Y" + y);
            if (flagX && flagY)
            {
                if(stateShipVerOrHor == 1)
                {
                    for (int i = indexX; i < indexX + stateShip; i++)
                    {
                        arrayField[i][indexY] = 1;
                    }
                }else
                    {
                        for (int i = indexX; i <= indexX; i++)
                        {
                            for (int j = indexY; j < indexY + stateShip; j++)
                            {
                                arrayField[i][j] = 1;
                            }
                        }
                    }
//                arrayField[indexX][indexY] = 1;
            }
        }
    }

    private void drawCell(Graphics g)
    {
//        Graphics2D graphics2D = (Graphics2D) g;
//        graphics2D.setStroke(new BasicStroke(5.00f));
//        graphics2D.setColor(Color.red);

        for (int i = 0; i < arrayField.length; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                if (arrayField[i][j] == 1) {
                    g.fillRect(i * recWidth + right, j * recHeight + top, recWidth, recHeight);
//                    graphics2D.drawRect(i * recWidth + right, j * recHeight + top, recWidth, recHeight);
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
                //super.mouseClicked(e);
                System.out.println("CLICK");
                setCor(left, width - right, width - left - right, e.getX(),e.getY());
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                //flag = true;

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                flag = true;
                System.out.println("ON");
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e)
            {
                flag = false;
                System.out.println("EXIT");
                repaint();
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
                if(flag)
                {
                    mouseX = e.getX();
                    mouseY = e.getY();
                    checkCell(left, width - right, width - left - right, e.getX(),e.getY());
//                    System.out.println(mouseX + " ======= " + mouseY);
                    repaint();
                }
            }
        });
    }

    public void setButtonState(String state)
    {
        buttonState = state;
        System.out.println(buttonState + getClass());
        getNameStateButton(buttonState);
    }

    public void getNameStateButton(String name)
    {
        if(name.equals("OneShip"))
        {
            stateShip = 1;

        }else if(name.equals("TwoShip"))
        {
            stateShip = 2;
        }else if(name.equals("ThreeShip"))
        {
            stateShip = 3;
        }else if(name.equals("FourShip"))
        {
            stateShip = 4;
        }else if(name.equals("VerOrHor"))
        {
            if(stateShipVerOrHor == 1)
            {
                stateShipVerOrHor = 2;
            }else {stateShipVerOrHor = 1;}
        }else if(name.equals("New"))
        {

        }
    }

    private boolean checkCell(int startPoz, int border, int length, int corX, int corY)
    {
        int x = corX;
        int y = corY;
        int indexX = 0, indexY = 0;
        boolean flag = false;
        boolean flagX = false;
        boolean flagY = false;
        System.out.println("x " + x + " " + startPoz + " " + length);
        if((x >= startPoz && x <= border)  && (y >= top && y <= height - bottom))
        {

            for (int i = startPoz, i2 = 0; i <= length + startPoz; i += recWidth, i2++)
            {
                System.out.println("i " + i + " " + x);
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
            System.out.println(x + " X ---- Y" + y);
            if (flagX && flagY) {
                if(arrayField[indexX][indexY] == 1) {
                    return false;
                }else {
                    if (stateShipVerOrHor == 1) {
                            if(stateShip == 1)
                            {
                                flag = checkOneShipHOrV(indexX, indexY);
                            }else if(stateShip == 2)
                            {
                                flag = checkTwoShipH(indexX, indexY);
                            }else if(stateShip == 3)
                            {
                                flag = checkThreeShipH(indexX, indexY);
                            } else if(stateShip == 4)
                            {
                                flag = checkFourShipH(indexX, indexY);
                            }
                        } else
                            {
//                                if(stateShip == 1)
//                                {
//                                    flag = checkOneShipHOrV(indexX, indexY);
//                                }
//                                else if(stateShip == 2)
//                                {
//                                    flag = checkTwoShipH(indexX, indexY);
//                                }else if(stateShip == 3)
//                                {
//                                    flag = checkThreeShipH(indexX, indexY);
//                                } else if(stateShip == 4)
//                                {
//                                    flag = checkFourShipH(indexX, indexY);
//                                }
                            }
                }
            }
        }
        return flag;
    }

    private boolean checkOneShipHOrV(int startX, int startY)
    {
        int top = 1;
        int bottom = 1;
        int left = 1;
        int right = 1;
                                              //top
        if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0)&&
                                                //right_top
                (arrayField[startX + right][startY - top] != 1 && arrayField[startX + right][startY - top] >= 0 &&
                        arrayField[startX + right][startY - top] <= arrayField.length)&&
                                                //right
                (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                                                //right_bottom
                (arrayField[startX + right][startY + bottom] != 1 && arrayField[startX + right][startY + bottom] <= arrayField[1].length &&
                        arrayField[startX + right][startY + bottom] <= arrayField.length)&&
                                                //bot
                (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length) &&
                                                //bot_left
                (arrayField[startX - left][startY + bottom] != 1 && arrayField[startX - left][startY + bottom] <= arrayField[1].length &&
                        arrayField[startX - left][startY + top] >= 0)&&
                                                //left
                (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                                                //left_top
                (arrayField[startX - left][startY - top] != 1 && arrayField[startX - left][startY - top] >= 0 &&
                        arrayField[startX - left][startY - top] >= 0)))
        {
            return false;
        }
        return true;
    }

    private boolean checkTwoShipH(int startX, int startY)
    {
        int top = 1;
        int bottom = 1;
        int left = 1;
        int right = 1;

        for (int i = 1; i <= stateShip; i++) {
            if (i == 1) {
                if (!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX - left][startY - top] != 1 && arrayField[startX - left][startY - top] >= 0 &&
                                arrayField[startX - left][startY - top] >= 0) &&
                        (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                        (arrayField[startX - left][startY + bottom] != 1 && arrayField[startX - left][startY + bottom] <= arrayField[1].length &&
                                    arrayField[startX - left][startY + top] >= 0) &&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length)&&
                        (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length))) {return false;}
                } else if (i == stateShip)
                {
                    startX++;
                    if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX + right][startY - top] != 1 && arrayField[startX + right][startY - top] >= 0 &&
                                arrayField[startX + right][startY - top] <= arrayField.length)&&
                        (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                        (arrayField[startX + right][startY + bottom] != 1 && arrayField[startX + right][startY + bottom] <= arrayField[1].length &&
                                arrayField[startX + right][startY + bottom] <= arrayField.length)&&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length) &&
                            (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0))) {return false;}
                }
        }
        return true;
    }

    private boolean checkThreeShipH(int startX, int startY)
    {
        int top = 1;
        int bottom = 1;
        int left = 1;
        int right = 1;

        for (int i = 1; i <= stateShip; i++) {
            if (i == 1) {
                if (!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX - left][startY - top] != 1 && arrayField[startX - left][startY - top] >= 0 &&
                                arrayField[startX - left][startY - top] >= 0) &&
                        (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                        (arrayField[startX - left][startY + bottom] != 1 && arrayField[startX - left][startY + bottom] <= arrayField[1].length &&
                                arrayField[startX - left][startY + top] >= 0) &&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))) {return false;}
                } else if (i > 1 && i < stateShip) {
                startX++;
                    if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                            (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                            (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                            (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))){return false;}
                } else if (i == stateShip) {
                startX++;
                    if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX + right][startY - top] != 1 && arrayField[startX + right][startY - top] >= 0 &&
                                arrayField[startX + right][startY - top] <= arrayField.length)&&
                        (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                        (arrayField[startX + right][startY + bottom] != 1 && arrayField[startX + right][startY + bottom] <= arrayField[1].length &&
                                arrayField[startX + right][startY + bottom] <= arrayField.length)&&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))){return false;}
                }
        }
        return true;
    }

    private boolean checkFourShipH(int startX, int startY)
    {
        int top = 1;
        int bottom = 1;
        int left = 1;
        int right = 1;

        for (int i = 1; i <= stateShip; i++) {
            if (i == 1) {
                if (!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX - left][startY - top] != 1 && arrayField[startX - left][startY - top] >= 0 &&
                                arrayField[startX - left][startY - top] >= 0) &&
                        (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                        (arrayField[startX - left][startY + bottom] != 1 && arrayField[startX - left][startY + bottom] <= arrayField[1].length &&
                                arrayField[startX - left][startY + top] >= 0) &&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))) {return false;}
            } else if (i > 1 && i < stateShip - 1) {
                 startX++;
                if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                        (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))){return false;}
            } else if (i > 1 && i < stateShip) {
                startX++;
                if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                        (arrayField[startX - left][startY] != 1 && arrayField[startX - left][startY] >= 0) &&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))){return false;}
            }else if (i == stateShip) {
                startX++;
                if(!((arrayField[startX][startY - top] != 1 && arrayField[startX][startY - top] >= 0) &&
                        (arrayField[startX + right][startY - top] != 1 && arrayField[startX + right][startY - top] >= 0 &&
                                arrayField[startX + right][startY - top] <= arrayField.length)&&
                        (arrayField[startX + right][startY] != 1 && arrayField[startX + right][startY] <= arrayField.length) &&
                        (arrayField[startX + right][startY + bottom] != 1 && arrayField[startX + right][startY + bottom] <= arrayField[1].length &&
                                arrayField[startX + right][startY + bottom] <= arrayField.length)&&
                        (arrayField[startX][startY + bottom] != 1 && arrayField[startX][startY + bottom] <= arrayField[1].length))){return false;}
            }
        }
        return true;
    }

}
