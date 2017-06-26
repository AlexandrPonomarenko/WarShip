package m.pac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main_Window extends JFrame
{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel mainPanel;
    private FirstPanel fp;
    private SecondPanel sp;
    private DinamicPanel dp;
    private DinamicSecondPanel dsp;
    private Drawing gr;
    private int width = 1000;
    private int height = 500;
    private boolean flag = true;

    public Main_Window()
    {
        setSize(new Dimension(width, height));

        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        setMainPanel(mainPanel);

        mainPanel.setLayout(new BorderLayout());

        fp = new FirstPanel(1000, 100);
        setFirstPanel(fp);

        sp = new SecondPanel(1000, 400);
        setSecondPanel(sp);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("New");
        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                setSizeFrame((width / 100) * 60, height);
                dp = new DinamicPanel((width / 100) * 60, getHeight());
                dsp = new DinamicSecondPanel((((width / 100) * 60) / 100) * 10, getHeight());
                System.out.println(getWidth() + " ccccccccccccccccccccc " + getHeight());
                mainPanel.removeAll();
                mainPanel.revalidate();
                repaint();
                //mainPanel.setLayout(new GridLayout(0,2));
                mainPanel.setLayout(new GridBagLayout());
                mainPanel.add(dsp, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.VERTICAL,
                        new Insets(0,0,0,0), 0,0));

                mainPanel.add(dp, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                        new Insets(0,0,0,0), 0,0));
                dsp.addMyEventListener(new MyEventListener() {
                    @Override
                    public void clickButton(MyEventObject eventObject) {
                        dp.setButtonState(eventObject.getState());
                    }
                });

                //pack();

            }
        });
        menu.add(menuItem);

        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        menu.add(itemExit);

        System.out.println(getSize() + "+++++++++++++++++++++++++++");
        clickMouseField();
        addWindowListener();
    }

    private void setMainPanel(JPanel panel)
    {
        add(panel, BorderLayout.CENTER);

        //panel.setBackground(Color.gray);
        System.out.println(panel.getSize() + "PERvaz panell");
    }

    private void setFirstPanel(JPanel panel)
    {
        mainPanel.add(panel, BorderLayout.NORTH);
        System.out.println(panel.getPreferredSize());
    }


    private void setSecondPanel(JPanel panel)
    {
        mainPanel.add(panel, BorderLayout.CENTER);
        System.out.println(panel.getPreferredSize());
    }

    private void setSizeFrame(int w, int h){setSize(w,h);}
    private void addWindowListener()
    {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
//                if(dsp != null && dp != null)
//                {
//                    dsp.setFlag(true);
//                    System.out.println("WINDOWLISTENER");
//                }
            }
            public void windowStateChanged(WindowEvent e)
            {
//                if(dsp != null && dp != null)
//                {
//                    dsp.setFlag(true);
//                    System.out.println("WINDOWLISTENER");
//                }
            }
        });
    }
    private void clickMouseField()
    {
        sp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(flag)
                {
                    sp.setFlag(flag);
                    System.out.println("HELLLO");
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        sp.findCorCell(e.getX(), e.getY());
                        repaint();
                        //clear.setEnabled(true);
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        //sp.deleteCor(e.getX(), e.getY());
                        //repaint();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
