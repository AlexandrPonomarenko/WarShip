package m.pac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main_Window extends JFrame
{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel mainPanel;
    private FirstPanel fp;
    private SecondPanel sp;
    private Drawing gr;
    private boolean flag = true;

    public Main_Window()
    {
        setSize(new Dimension(1000,500));

        //gbl = new GridBagLayout();
        setLayout(new BorderLayout());
        //gbc = new GridBagConstraints();

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
        clickMauseField();
    }

    private void setMainPanel(JPanel panel)
    {
        add(panel, BorderLayout.CENTER);

        panel.setBackground(Color.gray);
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

    private void clickMauseField()
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
