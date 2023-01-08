import Examples.Example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class contains the main frame
public class App
{
    public static JFrame f = new JFrame();
    JButton b = new JButton();
    JTextField starDateText = new JTextField();
    JTextField copyrightText = new JTextField();
    Stardate stardate = new Stardate();

    public void main()
    {
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.black);
        f.setLayout(null);
        f.setVisible(true);
        stardateDisplay();
        copyrightDisplay();
        b.setBackground(Color.black);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setBounds((f.getWidth() - 360)/2,(f.getHeight() - 130)/2 ,180, 70);
        b.addActionListener(new Transition(Menu.example));
        b.setText("Sus");
        b.setForeground(Color.WHITE);
        f.add(starDateText);
        f.add(copyrightText);
        //f.add(b);
        f.revalidate();
    }

    void stardateDisplay()
    {
        starDateText.setFont(new Font("LCARSGTJ3", Font.PLAIN, 32));
        starDateText.setText(Integer.toString(stardate.stardate()));
        starDateText.setBorder(BorderFactory.createEmptyBorder());
        starDateText.setBackground(Color.black);
        starDateText.setForeground(new Color(255, 204, 102));
        starDateText.setBounds((f.getWidth())/2,(f.getHeight())/2, 180, 70);
        starDateText.setVisible(true);
    }

    void copyrightDisplay()
    {
        //TODO copyright symbol for used font
        copyrightText.setFont(new Font("LCARSGTJ3", Font.PLAIN, 16));
        copyrightText.setText("Font © gtjlcars.de");
        copyrightText.setBorder(BorderFactory.createEmptyBorder());
        copyrightText.setBackground(Color.black);
        copyrightText.setForeground(new Color(255, 204, 102));
        copyrightText.setBounds((f.getWidth())/2,(f.getHeight())/2-1, 180, 70);
        copyrightText.setVisible(true);
    }
}

class Transition implements ActionListener
{
    Menu nextMenu;
    static App app = new App();
    static Example example = new Example();

    public Transition(Menu m)
    {
        nextMenu = m;
    }

    public void actionPerformed(ActionEvent e)
    {
        App.f.setVisible(false);
        App.f.setEnabled(false);
        switch (nextMenu)
        {
            case main -> {
                try
                {
                    app.main();
                }
                catch (Exception ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            case example -> example.main();
        }
    }
}