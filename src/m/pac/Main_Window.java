package m.pac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Window extends JFrame
{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel mainPanel;
    private FirstPanel fp;
    private SecondPanel sp;
    private Drawing gr;

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

        //gr = new Drawing(1000, 500, sp);
        //mainPanel.add(gr);
        //gr.setBackground(Color.BLUE);
        System.out.println(getSize() + "+++++++++++++++++++++++++++");
    }

    private void setMainPanel(JPanel panel)
    {

//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridheight = GridBagConstraints.REMAINDER;
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//        gbc.insets = new Insets(0,0,0,0);
//        gbc.ipadx = 0;
//        gbc.ipady = 0;

        //gbl.setConstraints(panel, gbc);
        add(panel, BorderLayout.CENTER);

//        add(panel, new GridBagConstraints(GridBagConstraints.RELATIVE,GridBagConstraints.RELATIVE,GridBagConstraints.REMAINDER,GridBagConstraints.REMAINDER,1,1,
//                GridBagConstraints.NORTHWEST,GridBagConstraints.BOTH,
//                new Insets(0,0,0,0), 0, 0));
        panel.setBackground(Color.gray);
        System.out.println(panel.getSize() + "PERvaz panell");
    }

    private void setFirstPanel(JPanel panel)
    {
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridheight = GridBagConstraints.REMAINDER;
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
//        gbc.anchor = GridBagConstraints.NORTHWEST;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//        gbc.insets = new Insets(0,0,0,0);
//        gbc.ipadx = 0;
//        gbc.ipady = 0;

        //mainPanel.setLayout( new GridBagLayout());
//        gbl.setConstraints(panel, gbc);
//        mainPanel.add(panel);
        //panel.setPreferredSize(new Dimension(1000, 100));
//        mainPanel.add(panel, new GridBagConstraints(0, 0, 1, 1, 0.7, 0.3, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
//                new Insets(0, 0, 0, 0), 0,0));
        //panel.setBackground(Color.BLUE);
        //mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel, BorderLayout.NORTH);

        System.out.println(panel.getPreferredSize());
    }


    private void setSecondPanel(JPanel panel)
    {
        mainPanel.add(panel, BorderLayout.CENTER);
        System.out.println(panel.getPreferredSize());
    }
}
